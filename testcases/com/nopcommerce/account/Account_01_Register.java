package com.nopcommerce.account;

import org.testng.annotations.Test;

import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Account_01_Register {
	WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	String projectPath = System.getProperty("user.dir");

	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
	}

	@Test
	public void Register_01_Empty_Data() {
		
		registerPage = homePage.clickRegisterLink();
		registerPage.inputFirstName("");
		registerPage.inputLastName("");
		registerPage.inputEmail("");
		registerPage.inputPassword("");
		registerPage.inputConfirmPassword("");
		registerPage.clickRegisterButton();
		
		Assert.assertEquals(registerPage.getFirstNameRequiredErrorMsg(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameRequiredErrorMsg(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailRequiredErrorMsg(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordRequiredErrorMsg(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordRequiredErrorMsg(), "Password is required.");

	}

	@Test	
	public void Register_02_Email_Incorrect() {
		registerPage = homePage.clickRegisterLink();
		registerPage.inputFirstName("test First Name");
		registerPage.inputLastName("test Last Name");
		registerPage.inputEmail("testEmail@123.66");
		registerPage.inputPassword("pass12345");
		registerPage.inputConfirmPassword("pass12345");
		registerPage.clickRegisterButton();
		
		Assert.assertEquals(registerPage.getVaidationErrorMsg(), "Wrong email");	
	}

	@Test
	public void Register_03_Password_Fewer_Than_6_Chars() {

	}

	@Test
	public void Register_04_Password_And_Confirm_Password_Not_Match() {

	}

	@Test
	public void Register_05_Valid_Data() {

	}

	@Test
	public void Register_06_Existed_Email() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
