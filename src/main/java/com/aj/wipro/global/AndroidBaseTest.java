package com.aj.wipro.global;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aj.wipro.report.CustomReport;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.appium.java_client.android.AndroidDriver;

@SuppressWarnings("rawtypes")
public class AndroidBaseTest extends CustomReport{
	protected static AndroidDriver androidDriver;

	public static AndroidDriver getAndroidDriver() {
		return androidDriver;
	}

	/* Initilization of Android Driver */

	@BeforeMethod
	public static AndroidDriver launchAndroidDriver() {
		DOMConfigurator.configure("log4j.xml");
		try {
			androidDriver = (AndroidDriver) DesiredDriver.getDriverInstance("Android");

		} catch (MalformedURLException e) {

			Reporter.log("Android Driver Instantiation Failed .........");
			test.log(Status.INFO, MarkupHelper.createLabel(e.getMessage(), ExtentColor.RED));
			e.printStackTrace();
		}
		return androidDriver;
	}

	@AfterMethod
	public void quitDriver() throws InterruptedException {
		Thread.sleep(15000);
		androidDriver.quit();

	}


	private static String value;


	private static String ReadFile(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./android_elements.properties");
		prop.load(fis);
		return prop.getProperty(key);

	}

	/* get the data from properties file */
	public String getConfigProperty(String key) {

		try {
			value = ReadFile(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;

	}




}
