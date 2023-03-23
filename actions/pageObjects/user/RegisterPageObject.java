package pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.user.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputFirstName(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME);
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME, firstName);
	}

	public void inputLastName(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME);
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME, lastName);
	}

	public void inputEmail(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL);
		sendKeyToElement(driver, RegisterPageUI.EMAIL, email);
	}

	public void inputPassword(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD, password);
	}

	public void inputConfirmPassword(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD, confirmPassword);
	}

	public String getFirstNameRequiredErrorMsg() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_REQUIRED_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_REQUIRED_ERROR_MSG);
	}

	public String getLastNameRequiredErrorMsg() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_REQUIRED_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.LAST_NAME_REQUIRED_ERROR_MSG);
	}

	public String getEmailRequiredErrorMsg() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_REQUIRED_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.EMAIL_REQUIRED_ERROR_MSG);
	}

	public String getPasswordRequiredErrorMsg() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_REQUIRED_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.PASSWORD_REQUIRED_ERROR_MSG);
	}

	public String getConfirmPasswordRequiredErrorMsg() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_REQUIRED_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_REQUIRED_ERROR_MSG);
	}

	public void clickRegisterButton() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_BTN);
		clickToElement(driver, RegisterPageUI.REGISTER_BTN);
	}

	public String getVaidationErrorMsg() {
		waitForElementVisible(driver, RegisterPageUI.VALIDATION_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.VALIDATION_ERROR_MSG);
	}

}
