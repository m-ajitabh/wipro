package com.aj.wipro.global;

import io.appium.java_client.android.AndroidDriver;

@SuppressWarnings("rawtypes")
public class DriverManager {

	private static ThreadLocal<AndroidDriver> androidDriver = new ThreadLocal<AndroidDriver>();

	public static AndroidDriver getAndroidDriver() {
		return androidDriver.get();
	}

	public static void setAndroidDriver(AndroidDriver driver) {
		androidDriver.set(driver);
	}

}
