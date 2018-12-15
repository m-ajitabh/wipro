package com.aj.wipro.screens;

import com.aj.wipro.global.AndroidBasePage;
import com.aj.wipro.global.CustomWait;
import com.aj.wipro.global.Log;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductDetailPage extends AndroidBasePage{

	AndroidDriver<AndroidElement> driver = getAndroidDriver();

	@AndroidFindBy(id="com.ebay.mobile:id/textview_item_price")
	public AndroidElement productPrice;

	@AndroidFindBy(id="com.ebay.mobile:id/button_bin")
	public AndroidElement productBuyButton;

	@AndroidFindBy(id="com.ebay.mobile:id/item_card_shipping_cost")
	public AndroidElement shippingCost;

	@AndroidFindBy(id="com.ebay.mobile:id/textview_estimated_delivery")
	public AndroidElement estimatedDeliveryDate;

	public float getProductPrice() {

		Float data = Float.parseFloat(CustomWait.waitForWebElementElementToBeVisible(productPrice).getText().toString());
		Log.info("Check product price: " + data);
		return data;
	}

	public float getShippingCost() {
		float data = Float.parseFloat(CustomWait.waitForWebElementElementToBeVisible(shippingCost).getText().toString());
		Log.info("Check Shipping cost: " + data);
		return data;
	}



	public EnterQuantityPage clickBuyProduct() {
		productBuyButton.click();
		Log.info("Buy button clicked");
		return new EnterQuantityPage();

	}

	public void clickProductBuyButton(){
		CustomWait.customImplicitWait(10);
		CustomWait.waitForAndroidElementToBeVisible(productBuyButton).click();
		Log.info("Product Buy button clicked");
	}

}
