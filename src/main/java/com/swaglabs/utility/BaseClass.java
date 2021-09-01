package com.swaglabs.utility;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.LogManager;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	public static AppiumDriver<MobileElement> driver;
	public static Logger log =Logger.getLogger("BaseClass.class");
	public static AppiumDriver<MobileElement> setUp() {
		try {		
			
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"ANDROID");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10 QKQ1.190915.002");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 7 Pro");
		cap.setCapability(MobileCapabilityType.UDID, "d9b3ca47");
//		cap.setCapability(MobileCapabilityType.APP, "");
		cap.setCapability("appPackage", "com.swaglabsmobileapp");
		cap.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver =new AppiumDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       
		try {
		if(driver.findElement(MobileBy.AccessibilityId("test-LOGIN")).isDisplayed()) {
			log.info("App Launched Successfully");
		}
		}catch(org.openqa.selenium.NoSuchElementException e1) {
			log.info("App not loaded properly");
		}

				return driver;
		}catch (Exception e) {
			e.printStackTrace();
			return driver;
		}
	}

}
