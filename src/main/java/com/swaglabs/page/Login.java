package com.swaglabs.page;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Login extends com.swaglabs.utility.BaseClass {
	

	public Login(AppiumDriver<MobileElement> driver) {
	}
		
	// Login
	public void clickonLogin(String username, String password) {
		MobileElement Usernametextfield=driver.findElement(MobileBy.AccessibilityId("test-Username"));
		MobileElement Password=driver.findElement(MobileBy.AccessibilityId("test-Password"));
		MobileElement LoginButton=driver.findElement(MobileBy.AccessibilityId("test-LOGIN"));

		Usernametextfield.sendKeys(username);
		Password.sendKeys(password);
		LoginButton.click();
		try {
			
		if(driver.findElementByXPath("//android.widget.TextView[@text='PRODUCTS']").isDisplayed()) {
			System.out.println("Loggedin Successfully");
			log.info("Loggedin Successfully");
		}
		}catch(org.openqa.selenium.NoSuchElementException e) {
			String msg=driver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")).getText();
			System.out.println(msg);
			log.info(msg);
		}

	}
	
	public void tapToAutoFill(String Usrname) {
		
		driver.findElement(MobileBy.AccessibilityId("test-"+Usrname)).click();
		driver.findElement(MobileBy.AccessibilityId("test-LOGIN")).click();
		try {
			
		if(driver.findElementByXPath("//android.widget.TextView[@text='PRODUCTS']").isDisplayed()) {
			System.out.println("Loggedin Successfully");
//			log.info("Loggedin Successfully");
		}
		}catch(org.openqa.selenium.NoSuchElementException e) {
			String errmsg=driver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")).getText();
			System.out.println(errmsg);
			log.info(errmsg);
			
		}
		
	}
	
}
