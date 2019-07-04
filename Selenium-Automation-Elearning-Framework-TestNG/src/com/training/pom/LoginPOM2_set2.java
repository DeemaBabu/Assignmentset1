package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPOM2_set2 {
	private WebDriver driver; 
	
	public LoginPOM2_set2(WebDriver driver) {
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
	private WebElement category; 
	
	
	@FindBy(xpath="//a[contains(text(),'Categories')]")
	private WebElement selCategory; 
	
	@FindBy(xpath="//a[contains(text(),'Products')]")
	private WebElement selProducts; 
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement Add; 
	
	@FindBy(id="input-name1")
	private WebElement name;
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement description;
	
	@FindBy(id="input-meta-title1")
	private WebElement metatag;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement save;
	
	@FindBy(xpath="//a[contains(text(),'Links')]")
	private WebElement links;
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement data;
	
	@FindBy(id="input-model")
	private WebElement modelname;
	
	@FindBy(id="input-category")
	private WebElement categoryname;
	
	
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

	public void clickCategory() {
		Actions find= new Actions(driver);
		find.moveToElement(category).build().perform();
		
		}
	
	public void clicksubCategory() {
		Actions find= new Actions(driver);
		find.moveToElement(selCategory).click().build().perform();
		
		}
	
	public void clickProducts() {
		Actions find= new Actions(driver);
		find.moveToElement(selProducts).click().build().perform();
		
		}
	
	public void clickadd() {
		this.Add.click();
	}
	public void sendname(String Name) {
		this.name.clear();
		this.name.sendKeys(Name);
	}
	public void sendMetatag(String metatag) {
		this.metatag.clear();
		this.metatag.sendKeys(metatag);
	}
	
	public void clicklink() {
		this.links.click();
	}
	public void clickdata() {
		this.data.click();
	}
	
	public void sendmodelname(String model) {
		this.modelname.sendKeys(model);
	
	}
	
	public void sendDescription(String description) {
		this.description.sendKeys(description);
	
	}
	public void save() {
		this.save.click();
		
	}
	public void enterCategory() {
		this.categoryname.click(); 
		driver.findElement(By.xpath("//a[contains(text(),'ORNAMENTS')]")).click();
	}	
}
