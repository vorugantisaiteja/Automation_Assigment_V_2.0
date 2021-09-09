package com.swaglabs.utility;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import com.swaglabs.utility.BaseClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Scroll extends BaseClass{
	
	//Invoking the constructor
	public Scroll(AppiumDriver<MobileElement> driver) {
		
	}
	
	//Scrolls until the specified element is displayed and clicks on it once it is displayed
	public void scroll_UntilElementFound(String ele) {
               
		       for(int i=0;i<=5;i++) {
		    	   TouchAction  action =new TouchAction(driver);	
					Dimension size	=driver.manage().window().getSize();
					int width=size.width;
					int height=size.height;				
					int middleOfX=width/2;
					int startYCoordinate= (int)(height*.5);
					int endYCoordinate= (int)(height*.2);

					
					new TouchAction((PerformsTouchActions) driver)
					.press(PointOption.point(middleOfX, startYCoordinate))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
					.moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
					try {
						
					
					if(driver.findElementByXPath("//android.widget.TextView[@text='"+ele+"']").isDisplayed()) {
						driver.findElementByXPath("//android.widget.TextView[@text='"+ele+"']").click();
						break;
					}
					}catch(org.openqa.selenium.NoSuchElementException e1) {
						continue;
						
					}
			}
		       		
		
	}
	
	//Scrolldown function
	public void scrollDown() {

		TouchAction  action =new TouchAction(driver);	
		Dimension size	=driver.manage().window().getSize();
		int width=size.width;
		int height=size.height;				
		int middleOfX=width/2;
		int startYCoordinate= (int)(height*.5);
		int endYCoordinate= (int)(height*.2);

		
		new TouchAction((PerformsTouchActions) driver)
		.press(PointOption.point(middleOfX, startYCoordinate))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();		
		
	}
	
	//Swipes from right to left based on the specified location
	public void scroll_RightToLeft() {
		MobileElement ele1=driver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc='test-Price']/android.widget.TextView"));
		Dimension size	=driver.manage().window().getSize();
		int width=size.width;
		int height1=size.height;				
		int middleOfY=ele1.getLocation().y+(ele1.getSize().height/2);
		int startXCoordinate=ele1.getLocation().x+(ele1.getSize().width/2);
		int endXCoordinate=ele1.getLocation().x+(ele1.getSize().width/4);
		
		new TouchAction((PerformsTouchActions) driver)
		.press(PointOption.point(startXCoordinate, middleOfY))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(endXCoordinate, middleOfY)).release().perform();
		
		try {
			if(driver.findElementByXPath("//android.view.ViewGroup[@content-desc='test-Delete']/android.view.ViewGroup").isDisplayed()) {
			log.info("Right to Left Swipe operation is successful");
			}
			
		}catch(org.openqa.selenium.NoSuchElementException e1) {
			log.info("Right to Left Swipe operation is not successful");
		
			
		}
		
		
	}

	}


