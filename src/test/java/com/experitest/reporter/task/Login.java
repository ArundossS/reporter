package com.experitest.reporter.task;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.experitest.reporter.task.TestBase;

public class Login extends TestBase {
	
	@Test
	public void login() {
		driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("company");
		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("company");
		driver.findElement(By.xpath("//*[@text='Login']")).click();	
		System.out.println(driver.findElement(By.tagName("H1")).getText());
		driver.findElement(By.xpath("//*[@text='Logout']")).click();
	}
	
}