package com.aj.wipro.testcases;

import org.testng.annotations.Test;

import com.aj.wipro.global.AndroidBaseTest;
import com.aj.wipro.global.CustomProperties;
import com.aj.wipro.screens.HomePage;
import com.aj.wipro.screens.LoginPage;
import com.aj.wipro.screens.PayNowPage;
import com.aj.wipro.workflow.LoginFlow;
import com.aj.wipro.workflow.ProductSearchFlow;

public class ProductPurchaseTest extends AndroidBaseTest{

	@Test
	public void test1() throws InterruptedException {

		test = extent.createTest("Verify the purchase of the product");

		String locale = CustomProperties.getConfigProperty("locale");
		LoginFlow loginFlow = new LoginFlow();
		HomePage homePage = loginFlow.setLocale("Ireland"); // Select different locale as app is not working in India

		LoginPage loginPage = homePage.selectLogin();

		homePage = loginFlow.enterLoginDetails();

		ProductSearchFlow searchFlow = new ProductSearchFlow();
		String product = CustomProperties.getConfigProperty("product");

		PayNowPage payPage = searchFlow.searchAndBuyProduct(homePage, product);

	}

}
