/*package com.aj.wipro.common;

import java.util.Scanner;

import org.openqa.selenium.WebElement;

import com.aj.wipro.global.AndroidBasePage;
import com.aj.wipro.global.CustomWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class CommonFunctions extends AndroidBasePage {

	// scroll methods

	public static String inputData(){

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter correct otp: ");
		String data = sc.next();

		return data.trim();
	}

	public static void scrollToElementVertical(WebElement sourceElement, WebElement targetElement, WebElement elementToFind,
			int scrollCount) throws Exception {
		TouchAction tAction = new TouchAction(androidDriver);
		int startx = CustomWait.waitForWebElementElementToBeVisible(sourceElement).getLocation().getX();
		int starty = sourceElement.getLocation().getY();
		int endx = targetElement.getLocation().getX();
		int endy = targetElement.getLocation().getY();
		int count = 0;
		while (count < scrollCount) {
			try {
				if (elementToFind.isDisplayed()) {
					System.out.println("Element found " + elementToFind);
					break;
				} else {

					tAction.press(PointOption.point(startx + 300, starty)).waitAction().moveTo(PointOption.point(endx + 300, endy)).release()
							.perform();
					Thread.sleep(1);
					count++;
				}
			} catch (Exception e) {
				tAction.press(PointOption.point(startx + 300, starty)).waitAction().moveTo(PointOption.point(endx + 300, endy)).release().perform();
				Thread.sleep(1);
				count++;

				System.out.println("scrolling failed " + elementToFind);
			}
		}
	}

	public static void scrollToElementHorizontal(WebElement sourceElement,WebElement targetElement, WebElement elementToFind, String category, int scrollCount) throws Exception {
		TouchAction tAction = new TouchAction(androidDriver);
		int startx = sourceElement.getLocation().getX();
		//int starty = sourceElement.getLocation().getY();
		int endx = targetElement.getLocation().getX();
		int y = sourceElement.getLocation().getY();
		int count = 0;
		//System.out.println("source x: "+ startx +" target x: " + endx);
		while (count < scrollCount) {
			try {
				System.out.println(elementToFind.getText());
				if (elementToFind.getText().equalsIgnoreCase(category)) {
					System.out.println("Element found " + elementToFind);
					break;
				} else {
					tAction.press(PointOption.point(startx, y)).waitAction().moveTo(PointOption.point(endx, y)).release()
							.perform();

					Thread.sleep(2000);
					count++;
				}
			} catch (Exception e) {
				//tAction.press(startx, y).waitAction().moveTo(endx, y).release().perform();
				Thread.sleep(1);
				count++;

				System.out.println("scrolling failed " + elementToFind);
			}
			Thread.sleep(5000);
		}


		String pageSource = getAndroidDriver().getPageSource();
		System.out.println(pageSource);


	}

}
*/