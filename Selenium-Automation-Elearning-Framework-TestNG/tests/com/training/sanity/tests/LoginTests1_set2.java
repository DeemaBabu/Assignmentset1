package com.training.sanity.tests;

/*RTTC_047 - medium To Verify whether application allows admin to filter details of order placed by the user*/

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LoginPOM1_set2;
import com.training.pom.LoginPOM2;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests1_set2 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM1_set2 loginPOM1_set2;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM1_set2 = new LoginPOM1_set2(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}
		

	@AfterClass
	
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority =1)
	public void validLoginTest() throws InterruptedException {
		loginPOM1_set2.sendUserName("admin");
		loginPOM1_set2.sendPassword("admin@123");
		loginPOM1_set2.clickLoginBtn();
		Thread.sleep(3000);
		screenShot.captureScreenShot("First");

	}
	//To filter using orderid 167, status pending, select date 2019-06-20 from calendar date created and date modified
	@Test(priority = 2)
	public void actualTest() throws InterruptedException {
		loginPOM1_set2.clickSales();
		loginPOM1_set2.clickOrder();
		Thread.sleep(2000);
		loginPOM1_set2.sendOrderID("167");
		Thread.sleep(3000);
		loginPOM1_set2.filter();
		Thread.sleep(2000);
		loginPOM1_set2.sendOderStatus("Pending");
		loginPOM1_set2.filter();
		Thread.sleep(3000);
		loginPOM1_set2.date();	
				
		//If user wants to pass values explicitly use below code
		/*loginPOM1_set2.dateAdded("2019-06-20");
		loginPOM1_set2.filter();
		Thread.sleep(3000);
		loginPOM1_set2.dateModified("2019-06-20");
		loginPOM1_set2.filter();*/
		Thread.sleep(2000);
	}
	
	
}
