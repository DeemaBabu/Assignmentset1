package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPOM3 {
	private WebDriver driver; 
	
	public LoginPOM3(WebDriver driver) {
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
	
	@FindBy(xpath="//td[contains(text(),'Test')]/preceding-sibling::td/input[@type='checkbox']")
	private WebElement selcheckbox; 
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement delProduct; 
	
		
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
	public void clickCheckbox() {
		this.selcheckbox.click();
	}
	public void clickDelete() {
		this.delProduct.click();
	}
	
}
