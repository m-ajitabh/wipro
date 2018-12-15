package com.aj.wipro.workflow;

import com.aj.wipro.global.CustomWait;
import com.aj.wipro.global.Log;
import com.aj.wipro.report.CustomReport;
import com.aj.wipro.screens.BuyItNowPage;
import com.aj.wipro.screens.EnterQuantityPage;
import com.aj.wipro.screens.HomePage;
import com.aj.wipro.screens.PayNowPage;
import com.aj.wipro.screens.ProductDetailPage;
import com.aj.wipro.screens.ProductListPage;
import com.aj.wipro.screens.SearchPage;

public class ProductSearchFlow extends CustomReport {


	public PayNowPage searchAndBuyProduct(HomePage homePage,String product) throws InterruptedException {

		Log.info("----- Product Search and Purchase flow started ----");
		test = extent.createTest("Verify the search of the product");
		SearchPage sp = homePage.clickSearchBox();

		ProductListPage pListPage = sp.enterSearch(product);

		pListPage.clickSavePopup();

		test = extent.createTest("Verify the product search list");
		ProductDetailPage pDetailPage = pListPage.clickProduct();

		test = extent.createTest("Verify the product details page");
		CustomWait.waitForAndroidElementExplicit(pDetailPage.productBuyButton);

		float productPrice = pDetailPage.getProductPrice();
		float shippingCost = 0;
		if(!pDetailPage.shippingCost.getText().toString().contains("free")){
			shippingCost = pDetailPage.getShippingCost();
		}

		CustomWait.customImplicitWait(3);

		test = extent.createTest("Verify the quantity page");

		EnterQuantityPage quantityPage = pDetailPage.clickBuyProduct();

		CustomWait.customImplicitWait(3);

		test = extent.createTest("Verify the Buy a product page");
		BuyItNowPage buyPage = quantityPage.clickReviewButton();


		float staticTotalPrice = Float.parseFloat(buyPage.productTotalPrice.getText().toString());

		Log.info("Calculate total price");
		float additionalCharge = 0;
		if(buyPage.additionalPrice.isDisplayed())
			additionalCharge = buyPage.getAdditionalPrice();
		float totalPrice = buyPage.getTotalPrice();

		Log.info("Product Price: " + productPrice);
		System.out.println(shippingCost);
		System.out.println(additionalCharge);
		System.out.println(totalPrice);


		return new PayNowPage();


	}

}
