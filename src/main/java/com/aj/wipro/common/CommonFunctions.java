package com.aj.wipro.common;

import org.openqa.selenium.WebElement;

import com.aj.wipro.global.AndroidBasePage;
import com.aj.wipro.global.CustomWait;

import io.appium.java_client.TouchAction;

public class CommonFunctions extends AndroidBasePage {



	/* vertical scroll
	 *
	 * sourceElement = The element whose area are tapped to scroll up or down
	 *
	 * targetElement = Static reference element till where the scroll happened up or down
	 *
	 * elementToFind = Element till the scroll happens
	 *
	 * scrollCount = This will stops from infinite loop
	 * */

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

					tAction.press(startx + 300, starty).waitAction().moveTo(endx + 300, endy).release()
							.perform();
					Thread.sleep(1);
					count++;
				}
			} catch (Exception e) {
				tAction.press(startx + 300, starty).waitAction().moveTo(endx + 300, endy).release().perform();
				Thread.sleep(1);
				count++;

				System.out.println("scrolling failed " + elementToFind);
			}
		}
	}




	/* Horizontal scroll
	 *
	 * sourceElement = The element whose area are tapped to scroll up or down
	 *
	 * targetElement = Static reference element till where the scroll happened up or down
	 *
	 * elementToFind = Element till the scroll happens
	 *
	 * scrollCount = This will stops from infinite loop
	 * */

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
					tAction.press(startx, y).waitAction().moveTo(endx, y).release()
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

	}

}
