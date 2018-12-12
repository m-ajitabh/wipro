package com.aj.wipro.global;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidBasePage extends AndroidBaseTest {

	/* Initialization of the page factory*/

	public AndroidBasePage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getAndroidDriver()), this);
	}

}
