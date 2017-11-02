package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod()
	public void setUp() {
		initialization();
		 loginpage = new LoginPage();
		 
	}
	


	
	@Test(priority=1)
	public void crmLogoTest() {
		boolean flag = loginpage.validedCrmLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void loginTest() {
		homePage = loginpage.validedLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=3)
	public void loginPageTitleTest() {
		loginpage.validedLogin(prop.getProperty("username"), prop.getProperty("password"));
		String title = loginpage.validedLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
