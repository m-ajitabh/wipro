package com.aj.wipro.screens;

import com.aj.wipro.global.AndroidBasePage;
import com.aj.wipro.global.CustomWait;
import com.aj.wipro.global.Log;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SelectCountryPage extends AndroidBasePage{
	@AndroidFindBy(id = "\"com.ebay.mobile:id/filter\"")
	AndroidElement filter;

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id='com.ebay.mobile:id/check_country']")
	AndroidElement setCountry;

	public CountryRegionPage searchAndSelectRegion(String country) {


		CustomWait.waitForAndroidElementToBeVisible(filter).clear();
		CustomWait.waitForAndroidElementToBeVisible(filter).sendKeys(country);

		CustomWait.waitForAndroidElementToBeVisible(setCountry).click();
		Log.info("Country searched and selected");

		return new CountryRegionPage();

	}

}
