package com.Skywareinventory.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.annotations.Test;

import com.Skywareinventory.pages.HomePage;
import com.Skywareinventory.pages.LoginPage;
import com.Skywareinventory.pages.MainPage;
import com.Skywareinventory.pages.MyProfilePage;
import com.Skywareinventory.pages.RegisterPage;
import com.Skywareinventory.utilities.ConfigurationReader;

public class TC013_Dashboard_EditContactInfo extends TestBase {
	HomePage homePage = new HomePage();
	LoginPage loginPage= new LoginPage();
	MainPage mainPage= new MainPage();
	MyProfilePage myProfile = new MyProfilePage();
	

	@Test
   public void Dashboard() {
		assertEquals(driver.getTitle(), "Skyware Inventory | Free Web Based Inventory Tracking Software");
		homePage.login.click();
		loginPage.username.sendKeys(ConfigurationReader.getProperty("username"));
		loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
		loginPage.submit.click();
		assertEquals(driver.getTitle(), "Skyware Inventory | Dashboard");
		assertEquals(mainPage.pageTitle.getText(),"Dashboard");
		mainPage.myProfile.click();
		assertEquals(driver.getTitle(), "Skyware Inventory | My Profile");
		myProfile.cookie.click();
		assertTrue(myProfile.editButton.isEnabled());
		myProfile.editButton.click();
		myProfile.country().selectByVisibleText("Belgium");
		myProfile.accountName.sendKeys("Cybertek");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",myProfile.saveButton);
		myProfile.saveButton.click();
		assertTrue(myProfile.success.isDisplayed());;
	
		
	
}
}
