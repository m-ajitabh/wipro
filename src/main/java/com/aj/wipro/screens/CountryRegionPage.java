package com.aj.wipro.screens;

import com.aj.wipro.global.AndroidBasePage;
import com.aj.wipro.global.CustomWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CountryRegionPage extends AndroidBasePage {

	AndroidDriver<AndroidElement> driver = getAndroidDriver();

	@AndroidFindBy(id = "android:id/switch_widget")
	public AndroidElement autoDetect;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"India\")")
	public AndroidElement selectCountry;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public AndroidElement backArrow;

	@AndroidFindBy(id = "\"com.ebay.mobile:id/filter\"")
	AndroidElement filter;

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id='com.ebay.mobile:id/check_country']")
	AndroidElement setCountry;


	public void clickAutoDetect() {
		CustomWait.waitForAndroidElementExplicit(autoDetect).click();
	}

	public void selectCountryRegion() {
		CustomWait.waitForAndroidElementExplicit(selectCountry);
		if(selectCountry.isEnabled()) {

			selectCountry.click();
			System.out.println("country clicked");
		}


	}



	public void searchAndSelectRegion(String country) {
		CustomWait.waitForAndroidElementToBeVisible(filter).clear();
		CustomWait.waitForAndroidElementToBeVisible(filter).sendKeys(country);

		CustomWait.waitForAndroidElementToBeVisible(setCountry).click();

	}

	public HomePage goBack() {

		backArrow.click();

		return new HomePage();
	}

}
