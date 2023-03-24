package common;

import org.openqa.selenium.WebDriver;

import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

public class PageGeneratorManager {
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
}
