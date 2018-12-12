package com.aj.wipro.screens;

import com.aj.wipro.global.AndroidBasePage;
import com.aj.wipro.global.CustomWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends AndroidBasePage {

	public static AndroidDriver<AndroidElement> driver = getAndroidDriver();

	@AndroidFindBy(id = "com.ebay.mobile:id/home")//(xpath = "//android.widget.ImageButton[@content-desc='Main navigation, open']")
	public AndroidElement hamburger;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Sign in,double tap to activate']")
	public AndroidElement signButton;


	@AndroidFindBy(id = "com.ebay.mobile:id/search_box")
	public AndroidElement searchBox;

	@AndroidFindBy(id = "com.ebay.mobile:id/menuitem_settings")
	public AndroidElement hambergerSetting;

	@AndroidFindBy(id = "com.ebay.mobile:id/gdpr_consent")
	public AndroidElement acceptAfterRegion;


	public void clickHamburger() {

		CustomWait.waitForMobileElementToBeVisible(hamburger).click();
	}

	public LoginPage clickSigninButton() {

		CustomWait.waitForMobileElementToBeVisible(signButton).click();
		return new LoginPage();
	}

	public SearchPage clickSearchBox() {

		CustomWait.waitForMobileElementToBeVisible(searchBox).click();

		return new SearchPage();
	}

	public SettingPage clickHambergerSetting() {
		CustomWait.waitForAndroidElementToBeVisible(hambergerSetting).click();
		return new SettingPage();
	}

	public LoginPage selectLogin() {

		AndroidElement signInButton = driver.findElementById("com.ebay.mobile:id/button_sign_in");

		CustomWait.waitForAndroidElementToBeVisible(signInButton).click();
		return new LoginPage();
	}

}
