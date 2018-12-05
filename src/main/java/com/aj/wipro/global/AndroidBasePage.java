package com.aj.wipro.global;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidBasePage extends AndroidBaseTest {

	public AndroidBasePage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getAndroidDriver()), this);
	}

}
