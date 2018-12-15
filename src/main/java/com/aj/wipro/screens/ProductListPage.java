package com.aj.wipro.screens;

import java.util.List;

import com.aj.wipro.global.AndroidBasePage;
import com.aj.wipro.global.CustomWait;
import com.aj.wipro.global.Log;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductListPage extends AndroidBasePage{


	@AndroidFindBy(id = "com.ebay.mobile:id/popup_container")
	AndroidElement savePopup;

	@AndroidFindBy(id = "com.ebay.mobile:id/cell_collection_item")
	List<AndroidElement> productList;

	public void clickSavePopup() {
		if(CustomWait.waitForAndroidElementExplicit(savePopup).isDisplayed())
			savePopup.click();
		Log.info("Save popup clicked");
	}

	public ProductDetailPage clickProduct() {
		if(!productList.isEmpty()) {
			productList.get(0).click();
			Log.info("Clicked product to goto product details page");
			return new ProductDetailPage();

		}
		else {
			Log.error("No product found");
			return null;
		}
	}
}
