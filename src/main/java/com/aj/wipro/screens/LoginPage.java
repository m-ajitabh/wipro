package com.aj.wipro.screens;

import java.util.List;

import com.aj.wipro.global.AndroidBasePage;
import com.aj.wipro.global.CustomWait;
import com.aj.wipro.global.Log;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends AndroidBasePage {

	public static AndroidDriver<AndroidElement> driver = getAndroidDriver();

	@AndroidFindBy(id = "com.ebay.mobile:id/button_google")
	public AndroidElement googleSignIn;

	@AndroidFindBy(id = "com.google.android.gms:id/account_display_name")
	List<AndroidElement> acc_picker;

	public HomePage clickGoogleSigIn() {

		CustomWait.waitForAndroidElementToBeVisible(googleSignIn).click();
		Log.info("Google Sign In clicked");

		CustomWait.waitForAndroidElementExplicit(acc_picker.get(1)).click();

		Log.info("Select google account from list");
		return new HomePage();
	}


}
