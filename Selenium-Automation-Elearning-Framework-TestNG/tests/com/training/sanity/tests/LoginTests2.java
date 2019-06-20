package com.training.sanity.tests;

/*To Verify whether application allows the admin to filter the product details*/

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LoginPOM2;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests2 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM2 loginPOM2;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM2 = new LoginPOM2(driver); 
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
		loginPOM2.sendUserName("admin");
		loginPOM2.sendPassword("admin@123");
		loginPOM2.clickLoginBtn();
		Thread.sleep(3000);
		screenShot.captureScreenShot("First");

	}
	//To search for product with product name Integer vitae iaculis massa and to search for price 515
	@Test(priority = 2)
	public void actualTest() throws InterruptedException {
		
		loginPOM2.clickCatalog();
		loginPOM2.clickProducts();
		Thread.sleep(2000);
		loginPOM2.sendProductname("Integer vitae iaculis massa");
		Thread.sleep(3000);
		loginPOM2.filter();
		Thread.sleep(2000);
		loginPOM2.sendprice("515");
		loginPOM2.filter();
		Thread.sleep(3000);
	}
	
	
}
