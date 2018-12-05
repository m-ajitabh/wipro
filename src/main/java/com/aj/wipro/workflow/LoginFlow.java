package com.aj.wipro.workflow;

import com.aj.wipro.global.CustomWait;
import com.aj.wipro.report.CustomReport;
import com.aj.wipro.screens.CountryRegionPage;
import com.aj.wipro.screens.HomePage;
import com.aj.wipro.screens.LoginPage;
import com.aj.wipro.screens.SettingPage;

public class LoginFlow extends CustomReport{


	public HomePage enterLoginDetails() {

		test = extent.createTest("Verify google login");
		LoginPage loginPage = new LoginPage();

		HomePage homePage = loginPage.clickGoogleSigIn();

		return homePage;
	}

	public HomePage setLocale(String country) {
		HomePage homePage = new HomePage();
		homePage.clickHamburger();
		test = extent.createTest("Verify the region change");
		SettingPage settingPage = homePage.clickHambergerSetting();
		CountryRegionPage regionPage =  settingPage.clickCountryRegion();
		regionPage.clickAutoDetect();
		regionPage.selectCountryRegion();
		regionPage.searchAndSelectRegion(country);
		homePage = regionPage.goBack();

		if(CustomWait.waitForAndroidElementToBeVisible(homePage.acceptAfterRegion).isDisplayed())
			homePage.acceptAfterRegion.click();

		return homePage;
	}

}
