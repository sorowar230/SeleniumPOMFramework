package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory - OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signupBtn;
	
	@FindBy(xpath="//img[contains(@class, 'img-responsive')]")
	WebElement crmLogo;
	
	//Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Action Methods:
	public String validedLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validedCrmLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage validedLogin(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}
}
