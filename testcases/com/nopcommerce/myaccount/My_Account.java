package com.nopcommerce.myaccount;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.MyAccountPageObject;

public class My_Account extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	MyAccountPageObject myAccountPage;
	LoginPageObject loginPage;

	String email, password;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

		email = "hpatt@live.com";
		password = "hpattest";

		loginPage = homePage.clickLoginLink();
		loginPage.inputEmail(email);
		loginPage.inputPassword(password);
		loginPage.clickLoginBtn();

		Assert.assertTrue(loginPage.isLogoutLinkDisplayed());
		
	}

	@Test
	public void My_Account_TC01_Update_Customer_Info() {
		myAccountPage = homePage.clickMyAccountLink();
		myAccountPage.selectFemaleGender();
		myAccountPage.inputFirstName("UpFirst");
		myAccountPage.inputLastName("UpLast");
		myAccountPage.selectDropdownByName(driver, "DateOfBirthDay", "20");
		myAccountPage.selectDropdownByName(driver, "DateOfBirthMonth", "March");
		myAccountPage.selectDropdownByName(driver, "DateOfBirthYear", "1995");
		myAccountPage.inputCompanyName("UpCom");
		myAccountPage.clickSaveBtn();

		Assert.assertEquals(myAccountPage.getUpdateSuccessMsg(), "The customer info has been updated successfully.");
		
	}

	@Test
	public void My_Account_TC02_Address() {

	}

	@Test
	public void My_Account_TC03_Change_Password() {

	}

	@Test
	public void My_Account_TC04_My_Product_Review() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
