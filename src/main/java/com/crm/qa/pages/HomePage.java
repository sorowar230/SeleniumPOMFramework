package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory
	@FindBy(xpath="//td[contains(text(), 'User: Sorowar jahan')]")	
	WebElement usernameLabel;
	

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(), 'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contain(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Initializing the Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return usernameLabel.isDisplayed();
	}
	
	public ContactsPage clickonContactsLink() {
		 contactsLink.click();
		 return new ContactsPage();
	}
	
	public DealsPage clickonDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickonTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}

}
