package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPOM4_set2 {
	private WebDriver driver; 
	
	public LoginPOM4_set2(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(id="menu-customer")
	private WebElement customer; 
	
	@FindBy(linkText="Customers")
	private WebElement Customers;
	
	public void clickCustomer() {
		Actions find= new Actions(driver);
		find.moveToElement(customer).click().build().perform();
	}
	public void clickCustomers() {
		this.Customers.click();
	}
		
	
	@FindBy(xpath="//td[contains(text(),'test@gmail.com')]/preceding-sibling::td/input[@type='checkbox']")
	private WebElement selcheckbox; 
	
	@FindBy(xpath="//td[contains(text(),'test@gmail.com')]//following-sibling::td[5]/a[@class='btn btn-primary']")
	private WebElement edit; 
	
	
	@FindBy(id="input-firstname")
	private WebElement firstname;
	
	@FindBy(linkText="Address 1")
	private WebElement address;
	
	@FindBy(id="input-postcode1")
	private WebElement postcode;
	

	@FindBy(linkText="Reward Points")
	private WebElement rewardpoints;
	
		
	@FindBy(id="input-reward-description")
	private WebElement rewarddesc;
	
	@FindBy(id="input-points")
	private WebElement points;
	
	@FindBy(id="button-reward")
	private WebElement addreward;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement save;
	
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
	
	public void clickCheckbox() {
		this.selcheckbox.click();
	}
	
	public void clickEdit() {
		this.edit.click();
	}
	public void sendFirstName(String firstname) {
		this.firstname.clear();
		this.firstname.sendKeys(firstname);
	}
	
	public void clickAddress1() {
		this.address.click();
	}
	public void sendPostcode(String postcode) {
		this.postcode.clear();
		this.postcode.sendKeys(postcode);
	}
	
	public void clickRewardPoints() {
		this.rewardpoints.click();
		
	}
	
	public void senddescription(String rewarddesc) {
		this.rewarddesc.clear(); 
		this.rewarddesc.sendKeys(rewarddesc); 
	}
	
	public void clickAddReward() {
		this.addreward.click(); 
	}

	public void sendPoints(String points) {
		this.points.clear();
		this.points.sendKeys(points);
	}
	
	public void save() {
		this.save.click();
		
	}
	
	
}
