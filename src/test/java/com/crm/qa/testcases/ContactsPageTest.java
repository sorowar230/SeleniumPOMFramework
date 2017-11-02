package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	
	String SheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	
	@BeforeMethod()
	public void setUp() {
		
		 initialization();
		 testUtil = new TestUtil();
		 contactsPage = new ContactsPage();
		 loginpage = new LoginPage();
		 dealsPage = new DealsPage();
		 homePage = loginpage.validedLogin(prop.getProperty("username"), prop.getProperty("password"));
		 testUtil.swichToFrame();
		 contactsPage = homePage.clickonContactsLink();
		 
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	
	}
	
	@Test(priority=2)
	public void selectSingleContactTest() {
		contactsPage.selectContactsByName("David Cris");
	}
	
	@Test(priority=3)
	public void selectMultippleContactTest() {
		contactsPage.selectContactsByName("David Cris");
		contactsPage.selectContactsByName("Jhon Doe");
	}
	
	
	@DataProvider()
	public Object[][] getCrmTestData() {
		Object data[][] = TestUtil.getTestData(SheetName);
		return data;
	}
	
	@Test(priority=4, dataProvider="getCrmTestData" )
	public void validateCreateNewContact(String title, String firstName, String lastName, String companyName){
		homePage.clickOnNewContactLink();
		///contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		   contactsPage.createNewContact(title, firstName, lastName, companyName);
		
	}
	
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
