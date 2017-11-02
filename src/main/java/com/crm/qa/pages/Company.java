package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Company extends TestBase  {
	
	public Company() {
		PageFactory.initElements(driver, this);
	}
}
