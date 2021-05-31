package com.korafood.dependencies;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchKoraFoodApp {

	org.apache.logging.log4j.Logger logger = LogManager.getLogger(LaunchKoraFoodApp.class);

	public AndroidDriver<WebElement> launchKoraFoodStreetMobileApp() throws MalformedURLException {

		// kept korafood street application apk under src/test/resources folder
		String apkPath = "src/test/resources/apps/KoraFoodTest.apk";

		File file = new File(apkPath);
		String absolutePath = file.getAbsolutePath();

		// creating object for desired capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		
		//setting capabilities for mobile device and storing in caps object
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9 PKQ1.180904.001");// Available in About Phone
		caps.setCapability(MobileCapabilityType.UDID, "ed3bcc5c");// by adb devices command we can get UDID
		caps.setCapability(MobileCapabilityType.APP, absolutePath);
		caps.setCapability("appPackage", "com.adaptteq.consulting.solutions.korafoodstreet");
		caps.setCapability("noReset", "true");
		
		//4723 is appium running port number & default adress is 0.0.0.0:4723
		//for every machine default address will be 127.0.0.1
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		//instantiating android driver and returning it
		return new AndroidDriver<WebElement>(url, caps);

	}
}
