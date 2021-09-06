package com.swaglabs.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class WaitUtility extends BaseClass{
	
	//Invoking the constructor
	public WaitUtility(AppiumDriver<MobileElement> driver) {
		
	}
    //Implicit wait function
	public void implicitwait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	//waits until the specified element is displayed, AccessibilityId should be given as input 
	public void until_Element_IsAccessible(String ele) {
		WebDriverWait wait = new WebDriverWait(driver,10);
   	 wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(ele)));
	}
}
