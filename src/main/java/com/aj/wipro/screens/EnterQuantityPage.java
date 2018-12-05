package com.aj.wipro.screens;

import com.aj.wipro.global.AndroidBasePage;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EnterQuantityPage extends AndroidBasePage{

	@AndroidFindBy(id="com.ebay.mobile:id/take_action")
	public AndroidElement reviewButton;

	public BuyItNowPage clickReviewButton() {
		reviewButton.click();

		return new BuyItNowPage();

	}


}
