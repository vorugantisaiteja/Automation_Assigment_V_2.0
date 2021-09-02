package com.swaglabs.utility;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class WaitUtility extends BaseClass{
	
	public WaitUtility(AppiumDriver<MobileElement> driver) {
		
	}

	public void implicitwait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
}
