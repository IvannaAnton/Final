package com.Skywareinventory.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Skywareinventory.utilities.ConfigurationReader;
import com.Skywareinventory.utilities.Driver;
import com.github.javafaker.Faker;

public class RegisterPage {

	public RegisterPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(id = "pageTitle")
	public WebElement pageTitle;

	@FindBy(id = "email")
	public WebElement email;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "password2")
	public WebElement confirmPasword;

	@FindBy(id = "accountName")
	public WebElement companyName;

	@FindBy(id = "profile_firstName")
	public WebElement firstName;

	@FindBy(id = "profile_lastName")
	public WebElement lastName;

	@FindBy(id = "countrySelect")
	public WebElement country;

	@FindBy(id = "profile_address1")
	public WebElement address;

	@FindBy(id = "profile_city")
	public WebElement city;

	@FindBy(id = "stateSelect")
	public WebElement state;

	@FindBy(id = "profile_zip")
	public WebElement zip;

	@FindBy(id = "profile_phone")
	public WebElement phoneNumber;

	@FindBy(id = "licenseAccepted")
	public WebElement licenseAccepted;

	@FindBy(id = "createButton")
	public WebElement createButton;

	@FindBy(xpath = "//div[@id='messages']")
	public WebElement message;

	@FindBy(id = "closeCookieConsentBtn")
	public WebElement cookie;
	
	public void RegisterUser() {
		email.sendKeys(new Faker().internet().emailAddress());
		password.sendKeys(ConfigurationReader.getProperty("password"));
		confirmPasword.sendKeys(ConfigurationReader.getProperty("password"));
	    companyName.sendKeys("Case 4te:");
		firstName.sendKeys(new Faker().name().firstName());
		lastName.sendKeys(new Faker().name().lastName());
		this.country().selectByIndex(new Faker().number().numberBetween(1, 40));;
		address.sendKeys(new Faker().address().streetAddress());
		city.sendKeys(new Faker().address().city());
		state.sendKeys(new Faker().address().state());
		zip.sendKeys(new Faker().address().zipCode());
		phoneNumber.sendKeys(new Faker().phoneNumber().cellPhone());
		licenseAccepted.click();
		createButton.click();
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOf(message));
        assertEquals(message.getText(), "Your new profile has been created! Please check your email to activate.");
		
	}

	public Select country() {
		return new Select(country);
	}

}
