package com.aj.wipro.workflow;

import com.aj.wipro.global.CustomWait;
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

		Thread.sleep(3000);

		test = extent.createTest("Verify the quantity page");

		EnterQuantityPage quantityPage = pDetailPage.clickBuyProduct();

		Thread.sleep(3000);

		test = extent.createTest("Verify the Buy a product page");
		BuyItNowPage buyPage = quantityPage.clickReviewButton();


		buyPage.productTotalPrice.getText().toString();


		float additionalCharge = 0;
		if(buyPage.additionalPrice.isDisplayed())
			additionalCharge = buyPage.getAdditionalPrice();
		float totalPrice = buyPage.getTotalPrice();

		System.out.println(productPrice);
		System.out.println(shippingCost);
		System.out.println(additionalCharge);
		System.out.println(totalPrice);


		return new PayNowPage();


	}

}
