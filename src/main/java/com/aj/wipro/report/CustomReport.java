package com.aj.wipro.report;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aj.wipro.global.AndroidBaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import io.appium.java_client.android.AndroidDriver;

public class CustomReport implements ITestListener {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	String dateName;
	static String reportFolder;
	@BeforeSuite
	public void startReport() {
		Date date = new Date();
		dateName = new SimpleDateFormat("yyyy-MM-dd-HHmmss").format(date);
		reportFolder = System.getProperty("user.dir") + "/" + "Reports" + "/" + "ExtentReports_" + dateName;
		File rdirectory = new File(System.getProperty("user.dir") + "/" + "Reports");
		File directory = new File(reportFolder);
		if (!rdirectory.exists()) {
			rdirectory.mkdir();
		}
		directory.mkdir();

		htmlReporter = new ExtentHtmlReporter(reportFolder+"/MyOwnReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	public static String getScreenshot(AndroidDriver driver, String screenshotName) throws Exception {
		// below line is just to append the date format with the screenshot name
		// to avoid duplicate names
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination =  reportFolder + "/"+ screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		// Returns the captured file path
		return destination;
	}

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	
	public void onTestFailure(ITestResult result) {
		String screenshotPath;
		try {
			screenshotPath = getScreenshot(AndroidBaseTest.getAndroidDriver(), "111111");
			test.log(Status.FAIL, test.addScreenCaptureFromPath(screenshotPath).toString());
			test.log(Status.INFO, MarkupHelper.createLabel(result.toString(), ExtentColor.RED));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// To add it in the extent report

	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@AfterTest
	public void quitReport() throws InterruptedException {
		extent.flush();
	}

}
