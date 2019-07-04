package com.training.sanity.tests;

/*RTTC_048 Medium -To verify whether application allows admin to create category & add product on the created category*/

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
import com.training.pom.LoginPOM;
import com.training.pom.LoginPOM2_set2;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests2_set2 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM2_set2 loginPOM2_set2;
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
		loginPOM2_set2 = new LoginPOM2_set2(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
		
	}

	@BeforeTest
	public void abc() {
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/abc.html",true);
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
		
	@AfterClass
	
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test(priority =1)
	public void validLoginTest() throws InterruptedException {

		loginPOM2_set2.sendUserName("admin");
		loginPOM2_set2.sendPassword("admin@123");
		loginPOM2_set2.clickLoginBtn();
		Thread.sleep(3000);
		screenShot.captureScreenShot("First");

	}
	//To click add category Ornaments
	@Test(priority = 2)
	public void actualTest() throws InterruptedException {
		logger=extent.startTest("Login");
		logger.log(LogStatus.PASS, "Successfully opened browser");
		
		//To click category and add category
		
		loginPOM2_set2.clickCategory();
		loginPOM2_set2.clicksubCategory();
		Thread.sleep(2000);
		loginPOM2_set2.clickadd();
		Thread.sleep(2000);
		loginPOM2_set2.sendname("ORNAMENTS");
		Thread.sleep(2000);
		loginPOM2_set2.sendDescription("ornaments for ladies");
		Thread.sleep(2000);
		loginPOM2_set2.sendMetatag("ORNAMENTS");
		Thread.sleep(2000);
		JavascriptExecutor Js = (JavascriptExecutor)driver;
		Js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		loginPOM2_set2.save();
		Thread.sleep(2000);
		
		//To click menu, select product and add product on the created category
		
		loginPOM2_set2.clickCategory();
		loginPOM2_set2.clickProducts();
		Thread.sleep(2000);
		loginPOM2_set2.clickadd();
		Thread.sleep(2000);
		loginPOM2_set2.sendname("Finger Ring");
		Thread.sleep(2000);
		loginPOM2_set2.sendMetatag("Finger Ring for ladies");
		Thread.sleep(2000);
		loginPOM2_set2.clickdata();
		loginPOM2_set2.sendmodelname("Test");
		loginPOM2_set2.clicklink();
		loginPOM2_set2.enterCategory();
		Thread.sleep(2000);
		JavascriptExecutor Js1 = (JavascriptExecutor)driver;
		Js1.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		loginPOM2_set2.save();
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}
}
