package com.experitest.reporter.task;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class TestBase {

	protected WebDriver driver;
	protected boolean isMobile;
	private String reportDirectory = "reports";
	private String reportFormat = "xml";
	private String testName = "Untitled";

	@Parameters({"Type","Query"})
	@BeforeTest
	public void beforeTest(String Param, String Query) throws MalformedURLException {
		System.out.println(Param);

		if (Param.equals("Android")){
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("reportDirectory", reportDirectory);
			dc.setCapability("reportFormat", reportFormat);
			dc.setCapability("testName", testName);
			dc.setCapability("user", "arundoss");
			dc.setCapability("password", "Cloud123");
			dc.setCapability("deviceQuery", Query);
			driver = new AndroidDriver<AndroidElement>(new URL("http://stage.experitest.com:80/wd/hub"), dc);
			isMobile = true;
		}
		else if (Param.equals("iOS")){
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("reportDirectory", reportDirectory);
			dc.setCapability("reportFormat", reportFormat);
			dc.setCapability("testName", testName);
			dc.setCapability("user", "arundoss");
			dc.setCapability("password", "Cloud123");
			dc.setCapability("deviceQuery", Query);
			driver = new IOSDriver<IOSElement>(new URL("http://stage.experitest.com:80/wd/hub"), dc);
			isMobile = true;
		}

	}



	@AfterTest 
	public void afterClass(){
		driver.quit();

	}
}

