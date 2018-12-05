package com.aj.wipro.screens;

import com.aj.wipro.global.AndroidBasePage;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PayNowPage extends AndroidBasePage {

	@AndroidFindBy(id="com.ebay.mobile:id/button_pay_now")
	public AndroidElement payNowButton;


}
