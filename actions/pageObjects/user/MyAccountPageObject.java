package pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.user.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
	WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickCustomerInfo() {
		waitForElementClickable(driver, MyAccountPageUI.CUSTOMER_INFO_LINK);
	}
	public void selectFemaleGender() {
		waitForElementClickable(driver, MyAccountPageUI.FEMALE_RADIO_BTN);
		clickToElement(driver, MyAccountPageUI.FEMALE_RADIO_BTN);

	}

	public void inputFirstName(String firstName) {
		waitForElementVisible(driver, MyAccountPageUI.FIRST_NAME_TXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.FIRST_NAME_TXTBOX, firstName);

	}

	public void inputLastName(String lastName) {
		waitForElementVisible(driver, MyAccountPageUI.LAST_NAME_TXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.LAST_NAME_TXTBOX, lastName);

	}

	public void inputCompanyName(String companyName) {
		waitForElementVisible(driver, MyAccountPageUI.COMPANY_NAME_TXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.COMPANY_NAME_TXTBOX, companyName);

	}

	public void clickSaveBtn() {
		waitForElementClickable(driver, MyAccountPageUI.SAVE_BTN);
		clickToElement(driver, MyAccountPageUI.SAVE_BTN);
	}

	public String getUpdateSuccessMsg() {
		waitForElementVisible(driver, MyAccountPageUI.UPDATE_SUCCESS_MSG);
		return getElementText(driver, MyAccountPageUI.UPDATE_SUCCESS_MSG);
		
	}

}
