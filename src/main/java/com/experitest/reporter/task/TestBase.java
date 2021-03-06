package com.experitest.reporter.task;


import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {


	//General
	protected static String buildId = System.getenv("BUILD_NUMBER");;

	//Grid
	private static final String GRID_USERNAME = System.getenv("SeeTestCloud_Username");
	private static final String GRID_PASSWORD = System.getenv("SeeTestCloud_Password");
	//private static final String GRID_PROJECT_NAME = System.getenv("SeeTestCloud_Project");
	private static final String GRID_URL = System.getenv("SeeTestCloud_Server_URL");

	//Client and Device
	protected AppiumDriver<WebElement> driver;

	private String reportDirectory = "reports";
	private String reportFormat = "xml";
	private String testName = "Arundoss_reporter_tests";

	@Parameters({"Type","Query"})
	@BeforeTest
	public void beforeTest(String Type, String Query) throws MalformedURLException {
		System.out.println(Type);

		if (Type.equals("Android")){
			System.out.println(buildId);
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("reportDirectory", reportDirectory);
			dc.setCapability("reportFormat", reportFormat);
			dc.setCapability("testName", testName);
			dc.setCapability("user", GRID_USERNAME);
			dc.setCapability("password", GRID_PASSWORD);
			dc.setCapability("deviceQuery", Query);
			dc.setCapability("build.id", buildId);
			driver = new AndroidDriver<WebElement>(new URL(GRID_URL+"80/wd/hub"), dc);
		}
		else if (Type.equals("iOS")){
			System.out.println(buildId);
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("reportDirectory", reportDirectory);
			dc.setCapability("reportFormat", reportFormat);
			dc.setCapability("testName", testName);
			dc.setCapability("projectName", "Default");
			dc.setCapability("user", GRID_USERNAME);
			dc.setCapability("password", GRID_PASSWORD);
			dc.setCapability("deviceQuery", Query);
			dc.setCapability("TestType", "2510-tests");
			dc.setCapability("build.id", buildId);
			dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
			dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
			dc.setCapability("instrumentApp", true);
			driver = new IOSDriver<WebElement>(new URL(GRID_URL+":80/wd/hub"), dc);
		}

	}



	@AfterTest 
	public void afterClass(){
		driver.quit();

	}
}

