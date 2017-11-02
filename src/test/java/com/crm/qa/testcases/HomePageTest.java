package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	
	LoginPage loginpage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod()
	public void setUp() {
		 initialization();
		 testUtil = new TestUtil();
		 loginpage = new LoginPage();
		 contactsPage = new ContactsPage();
		 dealsPage = new DealsPage();
		 
		 homePage = loginpage.validedLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyhomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO");
	}
	
	@Test(priority=2)
	public void verifyUserLabelTest() {
		testUtil.swichToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testUtil.swichToFrame();
		contactsPage = homePage.clickonContactsLink();
	}
	
	
	@Test(priority=4)
	public void verifyDealsLinkTest() {
		testUtil.swichToFrame();
		dealsPage =  homePage.clickonDealsLink();
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	

}
