package com.Skywareinventory.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Skywareinventory.utilities.Driver;

public class MainPage {
	public MainPage () {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy(id = "pageTitle")
	public WebElement pageTitle;
	
	@FindBy(linkText = "My Profile")
	public WebElement myProfile;
	
	
	
}
