package pageUIs.user;

public class MyAccountPageUI {
	
	/*
	 * Common
	 */
	public static final String BAR_NOTIFICATION_SUCCESS = "CSS=div[class*='bar-notification success']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "XPATH=//select[@name='%s']";

	/*
	 * Customerinfo
	 */
	public static final String CUSTOMER_INFO_LINK = "XPATH=//a[text()='Customer info']";
	public static final String MALE_RADIO_BTN = "ID=gender-male";
	public static final String FEMALE_RADIO_BTN = "ID=gender-female";
	public static final String FIRST_NAME_TXTBOX = "ID=FirstName";
	public static final String LAST_NAME_TXTBOX = "ID=LastName";
	public static final String COMPANY_NAME_TXTBOX = "ID=Company";
	public static final String SAVE_BTN = "ID=save-info-button";
	
	/*
	 * Add Addresses
	 */

	public static final String ADDDRESSES_LINK = "XPATH=//a[text()='Addresses']";
	public static final String ADD_NEW_BTN = "CSS=button[class$='add-address-button']";
	public static final String ADDRESS_FIRST_NAME_TXTBOX = "ID=Address_FirstName";
	public static final String ADDRESS_LAST_NAME_TXTBOX = "ID=Address_LastName";
	public static final String ADDRESS_EMAIL_TXTBOX = "ID=Address_Email";
	public static final String ADDRESS_COMPANY_TXTBOX = "ID=Address_Company";
	public static final String CITY_TXTBOX = "ID=Address_City";
	public static final String ADDRESS_1_TXTBOX = "ID=Address_Address1";
	public static final String ADDRESS_2_TXTBOX = "ID=Address_Address2";
	public static final String ZIP_POSTAL_CODE = "ID=Address_ZipPostalCode";
	public static final String PHONE_NUMBER_TXTBOX = "ID=Address_PhoneNumber";
	public static final String FAX_NUMBER_TXTBOX = "ID=Address_FaxNumber";
	public static final String SAVE_ADDRESS_BTN = "CSS=button[class$='save-address-button']";

}
