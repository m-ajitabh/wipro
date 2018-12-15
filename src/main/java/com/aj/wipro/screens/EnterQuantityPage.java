package com.aj.wipro.screens;

import com.aj.wipro.global.AndroidBasePage;
import com.aj.wipro.global.Log;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EnterQuantityPage extends AndroidBasePage{

	@AndroidFindBy(id="com.ebay.mobile:id/take_action")
	public AndroidElement reviewButton;

	public BuyItNowPage clickReviewButton() {
		reviewButton.click();
		Log.info("Review button on Buy it now page is clicked");
		return new BuyItNowPage();

	}


}
