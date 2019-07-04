package com.training.sanity.tests;

//RTTC_050 To verify whether application allows admin to edit Customer details & add reward points

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM3_set2;
import com.training.pom.LoginPOM4_set2;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests4_set2 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM4_set2 loginPOM4_set2;
	private static Properties properties;
	private ScreenShot screenShot;
	static ExtentReports extent;
	ExtentTest logger;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM4_set2 = new LoginPOM4_set2(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
		
		
	}

	@BeforeTest
	public void abc() {
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/medium4.html",true);
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		
	}
		
	@AfterClass
	
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();

	}
	@Test(priority =1)
	public void validLoginTest() throws InterruptedException {

		loginPOM4_set2.sendUserName("admin");
		loginPOM4_set2.sendPassword("admin@123");
		loginPOM4_set2.clickLoginBtn();
		Thread.sleep(3000);
		screenShot.captureScreenShot("First");

	}
	@Test(priority = 2)
	public void actualTest() throws InterruptedException {
		logger=extent.startTest("Assignment 4 - medium");
		logger.log(LogStatus.PASS, "Successfully opened browser");
		//To edit the customer details and add reward points
		
		loginPOM4_set2.clickCustomer();
		loginPOM4_set2.clickCustomers();;
		Thread.sleep(2000);
		loginPOM4_set2.clickCheckbox();
		Thread.sleep(2000);
		loginPOM4_set2.clickEdit();
		Thread.sleep(2000);
		loginPOM4_set2.sendFirstName("Asmita");
		Thread.sleep(2000);
		loginPOM4_set2.clickAddress1();
		loginPOM4_set2.sendPostcode("8796545");
		Thread.sleep(2000);
		JavascriptExecutor Js = (JavascriptExecutor)driver;
		Js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		Thread.sleep(2000);
		loginPOM4_set2.clickRewardPoints();
		
		loginPOM4_set2.senddescription("review");
		Thread.sleep(2000);
		loginPOM4_set2.sendPoints("50");
		Thread.sleep(2000);
		loginPOM4_set2.clickAddReward();
		Thread.sleep(2000);
		loginPOM4_set2.save();
		logger.log(LogStatus.PASS, "Successfully edited the customer details and added reward points");			
		extent.endTest(logger);
		extent.flush();
		extent.close();
		
	}
}
