package com.Skywareinventory.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Skywareinventory.utilities.Driver;

public class MyProfilePage {

	public  MyProfilePage () {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy(id = "pageTitle")
	public WebElement pageTitle;
	
	@FindBy(xpath= "(//input[@class='editButton'])[2]")
	public WebElement editButton;
	
	@FindBy(id="countrySelect")
	public WebElement  country;
	

	@FindBy(id="profile_accountName")
	public WebElement  accountName;
	
	@FindBy(xpath= "(//input[@class='saveButton'])[2]")
	public WebElement saveButton;
	
	@FindBy(id="ui-tooltip-0-title")
	public WebElement success;
	
	@FindBy(id = "closeCookieConsentBtn")
	public WebElement cookie;
	
	
	public Select country() {
		return new Select(country);
	}
	

}
