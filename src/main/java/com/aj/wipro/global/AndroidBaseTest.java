package com.aj.wipro.global;


import java.net.MalformedURLException;

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
	/*public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;*/

	
	public static AndroidDriver getAndroidDriver() {
		return androidDriver;
	}

	
	/*@BeforeTest
    public void startReport()
    {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/MyOwnReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }*/
	
	@BeforeMethod
	public static AndroidDriver launchAndroidDriver() {
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
		/*extent.flush();*/
	}
	
	/*@AfterTest
	public void quitReport() throws InterruptedException{
		extent.flush();
	}*/
	
	

}
