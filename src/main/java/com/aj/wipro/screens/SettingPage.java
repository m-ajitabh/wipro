package com.aj.wipro.screens;

import com.aj.wipro.global.AndroidBasePage;
import com.aj.wipro.global.CustomWait;
import com.aj.wipro.global.Log;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SettingPage extends AndroidBasePage{

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Country\")")
	public AndroidElement countryRegion;

	public CountryRegionPage clickCountryRegion() {
		CustomWait.waitForAndroidElementToBeVisible(countryRegion).click();
		Log.info("Country tab is clicked from settings");
		return new CountryRegionPage();
	}


}
