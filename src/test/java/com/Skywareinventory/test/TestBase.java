package com.Skywareinventory.test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.Skywareinventory.utilities.ConfigurationReader;
import com.Skywareinventory.utilities.Driver;


	public abstract class TestBase {
		protected WebDriver driver;
		
		@BeforeMethod
		public void setUp() {
			driver = Driver.getDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().fullscreen();
			driver.get(ConfigurationReader.getProperty("url"));

		}
		
		@AfterMethod(alwaysRun=true)
		public void tearDown() {
			Driver.closeDriver();
		}
		
}