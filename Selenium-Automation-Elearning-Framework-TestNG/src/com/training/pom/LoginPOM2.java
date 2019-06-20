package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPOM2 {
	private WebDriver driver; 
	
	public LoginPOM2(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(id="menu-catalog")
	private WebElement catalog; 
	
	
	@FindBy(xpath="//a[contains(text(),'Products')]")
	private WebElement selProducts; 
	
	@FindBy(id="input-name")
	private WebElement productname; 
	
	@FindBy(id="button-filter")
	private WebElement filter; 
	
	@FindBy(id="input-price")
	private WebElement price;
	
		
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	public void clickCatalog() {
		Actions find= new Actions(driver);
		find.moveToElement(this.catalog).click().build().perform();
		
		}
	public void clickProducts() {
		this.selProducts.click();
	}
	public void sendProductname(String productname) {
		this.productname.sendKeys(productname);
	}
	public void filter() {
		this.filter.click();
	}
	public void sendprice(String price) {
		this.price.sendKeys(price);
	}
}
