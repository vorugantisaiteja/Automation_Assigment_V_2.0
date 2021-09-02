package com.swaglabs.utility;


import java.io.BufferedReader;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
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
	public static String propertyFilePath="configs//Configuration.properties";
	public static String platform_name;
	public static String platform_version;
	public static String device_name;
	public static String udid;
	public static String app_package;
	public static String app_activity;
	
	public static AppiumDriver<MobileElement> setUp() {
		try {	
			BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
			Properties properties = new Properties();
			properties.load(reader);
			
			platform_name=properties.getProperty("PLATFORM_NAME");
			platform_version=properties.getProperty("PLATFORM_VERSION");
			device_name=properties.getProperty("DEVICE_NAME");
			udid=properties.getProperty("UDID");
			app_package=properties.getProperty("APP_PACKAGE");
			app_activity=properties.getProperty("APP_ACTIVITY");
					
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,platform_name);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_version);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
		cap.setCapability(MobileCapabilityType.UDID, udid);
//		cap.setCapability(MobileCapabilityType.APP, "");
		cap.setCapability("appPackage", app_package);
		cap.setCapability("appActivity", app_activity);
		
		URL url=new URL(properties.getProperty("URL"));
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
