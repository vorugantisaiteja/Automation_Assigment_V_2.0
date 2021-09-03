package com.swaglabs.utility;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class WaitUtility extends BaseClass{
	
	//Invoking the constructor
	public WaitUtility(AppiumDriver<MobileElement> driver) {
		
	}
    //Implicit wait function
	public void implicitwait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
}
