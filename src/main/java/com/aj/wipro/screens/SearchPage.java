package com.aj.wipro.screens;

import java.util.List;

import org.openqa.selenium.By;

import com.aj.wipro.global.AndroidBasePage;
import com.aj.wipro.global.CustomWait;

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


	public void clickBackArrow() {

		CustomWait.waitForMobileElementToBeVisible(backArrow).click();
	}



	public ProductListPage enterSearch(String product) {

		CustomWait.waitForMobileElementToBeVisible(searchProduct).clear();
		searchProduct.sendKeys(product);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<AndroidElement> list = driver.findElements(By.xpath("//android.widget.ListView[contains(@resource-id,'suggestionList')]/android.widget.RelativeLayout"));

		CustomWait.waitForMobileElementToBeVisible(list.get(0)).click();

		System.out.println(list.size());
		return new ProductListPage();


	}

}
