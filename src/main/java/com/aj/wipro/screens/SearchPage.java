package com.aj.wipro.screens;

import java.util.List;

import com.aj.wipro.global.AndroidBasePage;
import com.aj.wipro.global.CustomWait;
import com.aj.wipro.global.Log;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchPage extends AndroidBasePage {

	AndroidDriver<AndroidElement> driver = getAndroidDriver();

	@AndroidFindBy(id = "com.ebay.mobile:id/back_button")
	public MobileElement backArrow;

	@AndroidFindBy(id = "com.ebay.mobile:id/search_src_text")
	public MobileElement searchProduct;

	@AndroidFindBy(xpath ="//android.widget.ListView[contains(@resource-id,'suggestionList')]/android.widget.RelativeLayout")
	List<AndroidElement> list;


	public void clickBackArrow() {

		CustomWait.waitForMobileElementToBeVisible(backArrow).click();
		Log.info("Back arrow clicked in search page");
	}



	public ProductListPage enterSearch(String product) {

		CustomWait.waitForMobileElementToBeVisible(searchProduct).clear();
		searchProduct.sendKeys(product);
		Log.info("Search product entered");
		CustomWait.customImplicitWait(3);

		CustomWait.waitForMobileElementToBeVisible(list.get(0)).click();
		Log.info("1st product from searched list is clicked");
		return new ProductListPage();


	}

}
