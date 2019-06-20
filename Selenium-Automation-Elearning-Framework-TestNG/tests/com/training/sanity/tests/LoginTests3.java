package com.training.sanity.tests;

/*To Verify whether application allows the admin to delete a product from product list*/

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
import com.training.pom.LoginPOM3;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests3 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM3 loginPOM3;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM3 = new LoginPOM3(driver); 
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
		loginPOM3.sendUserName("admin");
		loginPOM3.sendPassword("admin@123");
		loginPOM3.clickLoginBtn();
		Thread.sleep(3000);
		screenShot.captureScreenShot("First");

	}
	
	
	//To delete the product 'Earring'
	@Test(priority = 2)
	public void actualTest() throws InterruptedException {
		
		loginPOM3.clickCatalog();
		loginPOM3.clickProducts();
		Thread.sleep(2000);
		loginPOM3.clickCheckbox();
		Thread.sleep(2000);
		loginPOM3.clickDelete();
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
	}
}
