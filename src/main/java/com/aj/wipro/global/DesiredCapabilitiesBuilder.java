package com.aj.wipro.global;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class DesiredCapabilitiesBuilder {

	/*Set the desired capabilities for the project */

	public static DesiredCapabilities getAndroidCapabilities() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, CustomProperties.getConfigProperty("deviceUDID"));

		capabilities.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS, true);

		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,
				CustomProperties.getConfigProperty("androidAppPackage"));
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
				CustomProperties.getConfigProperty("androidAppActivity"));
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
		capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");


		return capabilities;
	}

}
