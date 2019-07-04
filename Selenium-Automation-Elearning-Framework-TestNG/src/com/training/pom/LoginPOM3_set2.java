package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPOM3_set2 {
	private WebDriver driver; 
	
	public LoginPOM3_set2(WebDriver driver) {
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
	private WebElement menusale; 
	
	@FindBy(linkText="Returns")
	private WebElement returns;
		
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement Add; 
	
	@FindBy(id="input-order-id")
	private WebElement orderid;
	
	@FindBy(id="input-firstname")
	private WebElement firstname;
	
	@FindBy(id="input-customer")
	private WebElement custname;
	
	@FindBy(id="input-lastname")
	private WebElement lastname;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telephone;
	
	@FindBy(id="input-product")
	private WebElement productname;
	
	@FindBy(id="input-model")
	private WebElement model;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement save;
	
	@FindBy(xpath="//td[contains(text(),'90')]/preceding-sibling::td/input[@type='checkbox']")
	private WebElement selcheckbox; 
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement delete; 
	
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

	public void clickShoppingcart() {
		Actions find= new Actions(driver);
		find.moveToElement(menusale).click().build().perform();
	}
	public void clickReturns() {
		this.returns.click();
	}
	
	/*public void clickReturns() {
		Actions find= new Actions(driver);
		find.moveToElement(returns).click().build().perform();
		
		}*/
	public void clickadd() {
		this.Add.click();
	}
	public void sendOrderid(String orderid) {
		this.orderid.sendKeys(orderid);
	}
	public void sendFirstname(String firstname) {
		this.firstname.sendKeys(firstname);
	}
	public void sendLastname(String lastname) {
		this.lastname.sendKeys(lastname);
	}
	public void sendCustname(String custname) {
		this.custname.sendKeys(custname);
	}
	public void sendEmail(String email) {
		this.email.sendKeys(email);
	}
	public void sendTelephone(String telephone) {
		this.telephone.sendKeys(telephone);
	}
	public void sendProductname(String productname) {
		this.productname.sendKeys(productname);
	}
	
	public void sendmodelname(String model) {
		this.model.sendKeys(model);
	}
	public void save() {
		this.save.click();
		
	}
	
	public void clickCheckbox() {
		this.selcheckbox.click();
	}
	
	public void clickDelete() {
		this.delete.click();
	}
	
	

}
