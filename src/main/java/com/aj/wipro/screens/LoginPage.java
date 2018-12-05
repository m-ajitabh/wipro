package com.aj.wipro.screens;

import java.util.List;

import org.openqa.selenium.By;

import com.aj.wipro.global.AndroidBasePage;
import com.aj.wipro.global.CustomWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends AndroidBasePage {

	public static AndroidDriver<AndroidElement> driver = getAndroidDriver();

	@AndroidFindBy(id = "com.ebay.mobile:id/button_google")
	public AndroidElement googleSignIn;

	//@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"India\")")


	public HomePage clickGoogleSigIn() {

		CustomWait.waitForAndroidElementToBeVisible(googleSignIn).click();

		List<AndroidElement> acc_picker = driver.findElements(By.id("com.google.android.gms:id/account_display_name"));
		CustomWait.waitForAndroidElementExplicit(acc_picker.get(1)).click();

		return new HomePage();
	}


}
