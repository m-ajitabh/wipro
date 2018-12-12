package com.aj.wipro.screens;

import com.aj.wipro.global.AndroidBasePage;
import com.aj.wipro.global.CustomWait;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SettingPage extends AndroidBasePage{

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Country\")")
	public AndroidElement countryRegion;

	public CountryRegionPage clickCountryRegion() {
		CustomWait.waitForAndroidElementToBeVisible(countryRegion).click();
		return new CountryRegionPage();
	}


}
