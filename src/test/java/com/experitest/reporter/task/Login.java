package com.experitest.reporter.task;

import java.util.Random;

import org.openqa.selenium.By;

import org.testng.annotations.Test;
import com.experitest.reporter.task.TestBase;

public class Login extends TestBase {

	@Test
	public void login() {
		Random rand = new Random();
		int  n = rand.nextInt(10);
		driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("company");
		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("company");
		if (n<=5){

			driver.findElement(By.xpath("//*[@text='Login']")).click();	

		}
		driver.findElement(By.xpath("//*[@text='Logout']")).click();
	}
}