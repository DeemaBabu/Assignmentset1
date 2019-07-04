package com.training.sanity.tests;

/*RTTC_049 To verify whether application allows admin to return product of customer & delete from return list*/

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
import com.training.pom.LoginPOM3_set2;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests3_set2 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM3_set2 loginPOM3_set2;
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
		loginPOM3_set2 = new LoginPOM3_set2(driver); 
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
		driver.quit();
	}
	@Test(priority =1)
	public void validLoginTest() throws InterruptedException {

		loginPOM3_set2.sendUserName("admin");
		loginPOM3_set2.sendPassword("admin@123");
		loginPOM3_set2.clickLoginBtn();
		Thread.sleep(3000);
		screenShot.captureScreenShot("First");

	}
	@Test(priority = 2)
	public void actualTest() throws InterruptedException {
		logger=extent.startTest("Login");
		logger.log(LogStatus.PASS, "Successfully opened browser");
		
		//To click returns under shopping cart icon and add return
		
		loginPOM3_set2.clickShoppingcart();
		loginPOM3_set2.clickReturns();
		Thread.sleep(2000);
		loginPOM3_set2.clickadd();
		Thread.sleep(2000);
		loginPOM3_set2.sendOrderid("90");
		Thread.sleep(2000);
		loginPOM3_set2.sendFirstname("sooman");
		Thread.sleep(2000);
		loginPOM3_set2.sendCustname("sooman");
		Thread.sleep(2000);
		loginPOM3_set2.sendLastname("bose");
		Thread.sleep(2000);
		loginPOM3_set2.sendEmail("sbose@abc.com");
		Thread.sleep(2000);
		loginPOM3_set2.sendTelephone("9876543210");
		Thread.sleep(2000);
		loginPOM3_set2.sendProductname("Integer vitae iaculis massa");
		Thread.sleep(2000);
		loginPOM3_set2.sendmodelname("SKU-003");
		JavascriptExecutor Js = (JavascriptExecutor)driver;
		Js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		loginPOM3_set2.save();
		
		//To delete the return item
		Thread.sleep(2000);
		loginPOM3_set2.clickCheckbox();
		Thread.sleep(2000);
		loginPOM3_set2.clickDelete();
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}
}
