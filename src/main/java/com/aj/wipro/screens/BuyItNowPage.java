package com.aj.wipro.screens;

import com.aj.wipro.global.AndroidBasePage;
import com.aj.wipro.global.CustomWait;
import com.aj.wipro.global.Log;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BuyItNowPage extends AndroidBasePage{

	@AndroidFindBy(id="com.ebay.mobile:id/max_bid_value")
	public AndroidElement productTotalPrice;

	@AndroidFindBy(id="com.ebay.mobile:id/shipping_each_additional_textview")
	public AndroidElement additionalPrice;

	@AndroidFindBy(id="com.ebay.mobile:id/take_action")
	public AndroidElement buyItButton;


	public float getAdditionalPrice() {

		float data = Float.parseFloat(CustomWait.waitForWebElementElementToBeVisible(additionalPrice).getText().toString());
		Log.info("get additional price: " + data);
		return data;
	}

	public float getTotalPrice() {

		float data = Float.parseFloat(CustomWait.waitForWebElementElementToBeVisible(productTotalPrice).getText().toString());
		Log.info("get total price: " + data);
		return data;
	}

}
