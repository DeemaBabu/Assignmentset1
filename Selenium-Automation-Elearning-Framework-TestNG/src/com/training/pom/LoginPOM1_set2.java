package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPOM1_set2 {
	private WebDriver driver; 
	
	public LoginPOM1_set2(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(id="menu-sale")
	private WebElement sale; 
	
	
	@FindBy(xpath="//a[contains(text(),'Orders')]")
	private WebElement selOrder; 
	
	@FindBy(id="input-order-id")
	private WebElement orderid; 
	
	@FindBy(id="button-filter")
	private WebElement filter; 
	
	@FindBy(id="input-order-status")
	private WebElement orderstatus; 
	
	/*@FindBy(id="input-date-added")
	private WebElement dateadded;
	@FindBy(id="input-date-modified")
	private WebElement datemodified;*/
	
	@FindBy(xpath="//i[@class='fa fa-calendar']")
	private List<WebElement> calendar; 
	
	@FindBy(xpath="//td[@class='day' and contains(text(),'20')]")
	private WebElement seldate; 
		
		
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
	public void clickSales() {
		Actions find= new Actions(driver);
		find.moveToElement(this.sale).click().build().perform();
		
		}
	public void clickOrder() {
		this.selOrder.click();
	}
	public void sendOrderID(String orderid) {
		this.orderid.sendKeys(orderid);
	}
	public void filter() {
		this.filter.click();
	}
	public void sendOderStatus(String orderstatusval) {
		Select sel1=new Select(this.orderstatus);
		sel1.selectByVisibleText(orderstatusval);
	
	}
	public void date() {
		for(int i=0;i<this.calendar.size();i++)
		{
			this.calendar.get(i).click();
			this.seldate.click();
			this.filter.click();
			
		}
	}

	
	/*public void dateAdded(String dateadded) {
		this.dateadded.sendKeys(dateadded);
	}
	public void dateModified(String datemodified) {
		this.datemodified.sendKeys(datemodified);
	}*/
}
