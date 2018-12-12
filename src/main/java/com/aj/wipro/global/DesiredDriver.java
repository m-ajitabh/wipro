package com.aj.wipro.global;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DesiredDriver {
	private static String appiumHost = CustomProperties.getConfigProperty("appiumHost");
	private static String appiumPort = CustomProperties.getConfigProperty("appiumPort");
	private static String appiumServerURL = "http://" + appiumHost + ":" + appiumPort + "/wd/hub";


	/* This will return the driver as per driver type. As currently it is for Android and for iOS it is in progress*/

	@SuppressWarnings("rawtypes")
	public static AppiumDriver getDriverInstance(String driverType) throws MalformedURLException {
		AppiumDriver driver = null;
		if (driverType.equalsIgnoreCase("Android")) {
			driver = new AndroidDriver<AndroidElement>(new URL(appiumServerURL),
					DesiredCapabilitiesBuilder.getAndroidCapabilities());
		} else {
			driver = new AppiumDriver<MobileElement>(new URL(appiumServerURL),
					DesiredCapabilitiesBuilder.getAndroidCapabilities());


		}
		return driver;
	}

}
