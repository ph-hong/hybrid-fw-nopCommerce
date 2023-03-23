package common;

import org.openqa.selenium.WebDriver;

import pageObjects.user.RegisterPageObject;

public class PageGeneratorManager {
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
}
