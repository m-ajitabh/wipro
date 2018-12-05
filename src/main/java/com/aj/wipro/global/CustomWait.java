package com.aj.wipro.global;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class CustomWait extends AndroidBasePage {
	static WebDriver driver = getAndroidDriver();

	static MobileDriver mDriver = getAndroidDriver();

	public static WebElement loader(){
		WebElement element = driver.findElement(By.xpath("//android.widget.ProgressBar[@resource-id='com.pkd:id/progressBar']"));
		return element;
	}

	public static MobileElement waitForMobileElementToBeVisible(MobileElement element) {


		FluentWait fluentWait = new FluentWait(mDriver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOf(element));
		return element;

	}

	public static AndroidElement waitForAndroidElementToBeVisible(AndroidElement element) {

		FluentWait fluentWait = new FluentWait(getAndroidDriver()).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOf(element));
		return element;

	}

	public static AndroidElement waitForAndroidElementExplicit(AndroidElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));

		return element;

	}

	public static WebElement waitForWebElementElementToBeVisible(WebElement element) {

		FluentWait fluentWait = new FluentWait(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOf(element));
		return element;

	}



	public static void waitForPageToLoad(){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.invisibilityOf(loader()));
		}catch(Exception e){
		}
	}

}