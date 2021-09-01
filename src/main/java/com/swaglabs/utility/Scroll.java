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
	public Scroll(AppiumDriver<MobileElement> driver) {
		
	}
	
	public void scroll_UntilElementFound(String ele) {
//		String mainpath="//android.widget.TextView[@text='";
//		String endpath="']";
//		String finalpath;
//		finalpath=mainpath.concat(ele).concat(endpath);
		       for(int i=0;i<=5;i++) {
		    	   TouchAction  action =new TouchAction(driver);	
					Dimension size	=driver.manage().window().getSize();
					int width=size.width;
					int height=size.height;				
					int middleOfX=width/2;
					int startYCoordinate= (int)(height*.5);
					int endYCoordinate= (int)(height*.2);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					
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
	}


