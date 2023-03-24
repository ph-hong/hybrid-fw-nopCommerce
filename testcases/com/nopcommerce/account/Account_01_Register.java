package com.nopcommerce.account;

import org.testng.annotations.Test;

import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
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
	String email = "hpTest"+ randomNumber() + "@live.com";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
	}
	@Test
	public void Register_TC01_Empty_Data() {

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
		Assert.assertEquals(registerPage.getPasswordErrorMsg(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMsg(), "Password is required.");

	}
	@Test
	public void Register_TC02_Email_Incorrect() {
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
	public void Register_TC03_Password_Fewer_Than_6_Chars() {
		registerPage = homePage.clickRegisterLink();
		registerPage.inputFirstName("test First Name");
		registerPage.inputLastName("test Last Name");
		registerPage.inputEmail("atTestMail01@gmail.com");
		registerPage.inputPassword("12345");
		registerPage.inputConfirmPassword("12345");
		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getPasswordErrorMsg(),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test	
	public void Register_TC04_Password_And_Confirm_Password_Not_Match() {
		registerPage = homePage.clickRegisterLink();
		registerPage.inputFirstName("HP First Name");
		registerPage.inputLastName("HP Last Name");
		registerPage.inputEmail("atTestMail01@gmail.com");
		registerPage.inputPassword("123456");
		registerPage.inputConfirmPassword("123457");
		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getConfirmPasswordErrorMsg(),
				"The password and confirmation password do not match.");
	}

	@Test	
	public void Register_TC05_Valid_Data() {
		registerPage = homePage.clickRegisterLink();
		registerPage.inputFirstName("HP First Name");
		registerPage.inputLastName("HP Last Name");
		registerPage.inputEmail(email);
		registerPage.inputPassword("123456");
		registerPage.inputConfirmPassword("123456");
		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getSuccessRegisterMsg(),
				"Your registration completed");
	}

	@Test
	public void Register_TC06_Existed_Email() {
		registerPage = homePage.clickRegisterLink();
		registerPage.inputFirstName("HP First Name");
		registerPage.inputLastName("HP Last Name");
		registerPage.inputEmail(email);
		registerPage.inputPassword("123456");
		registerPage.inputConfirmPassword("123456");
		registerPage.clickRegisterButton();
		
		String emailValid = email;
		registerPage = homePage.clickRegisterLink();
		registerPage.inputFirstName("HP First Name 06");
		registerPage.inputLastName("HP Last Name 06");
		registerPage.inputEmail(emailValid);
		registerPage.inputPassword("123456");
		registerPage.inputConfirmPassword("123456");
		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getVaidationErrorMsg(),
				"The specified email already exists");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

}
