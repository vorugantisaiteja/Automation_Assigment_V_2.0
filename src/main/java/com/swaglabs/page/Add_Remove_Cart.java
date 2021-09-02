package com.swaglabs.page;

import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.swaglabs.utility.ScreenshotUtility;

public class Add_Remove_Cart extends com.swaglabs.utility.BaseClass{
	
	//Invoking the constructor
	public Add_Remove_Cart(AppiumDriver<MobileElement> driver) {
		
	}
//	Logger log=new Logger.getLogger(BaseClass.class);
	
	//Adds a product to the cart based on the index num
	public void add_ToCart(int num) throws IOException {
		String ele="(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[";
		String strend="]";
		String i=String.valueOf(num);
		String Combined=ele.concat(i).concat(strend);
//		System.out.println(Combined);
		driver.findElement(By.xpath(Combined)).click();
		try {
			
		
		if(driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='test-REMOVE']")).isDisplayed()) {
          System.out.println("Product Added Successfully");	
          log.info("Product Added Successfully");
          
		}
		}catch(org.openqa.selenium.NoSuchElementException e) {
			String product=driver.findElement(By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[2]")).getText();
			System.out.println("Bug: Could not add the product "+product);
			log.info("Bug: Could not add the product "+product);
			ScreenshotUtility scrnsht=new ScreenshotUtility(driver);
			scrnsht.screenshot("Bug-Unable to add product");
		}
		

	}
	
	/*Displays the cart status and displays the count of the 
	products which are there in the cart if it is not empty*/
	public void cart_status() {
		int status=0;
		log.info("Finding the Cart Status");
		try {		
		if(driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.view.ViewGroup")).isDisplayed()) {
			String count=driver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.TextView")).getText();
			System.out.println("Cart Status is not Empty");
			log.info("Cart Status is Not Empty");
			log.info("Products count in the cart: "+count);
			status=1;
		}
		}catch(org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Cart Status is Empty");
			log.info("Cart Status is Empty");
			status=0;

		}

//		return status;
	}
	
	 
    //Navigates to the cart
	public void gotoCart() {
		MobileElement cart=driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView"));
		cart.click();
        log.info("Navigated to the cart");
	}
	
	//Checks for the checkout button and clicks on checkout button
	public void checkout() {
		
		try {
		if(driver.findElement(MobileBy.AccessibilityId("test-CHECKOUT")).isDisplayed()) {
			driver.findElement(MobileBy.AccessibilityId("test-CHECKOUT")).click();
			log.info("Clicked on Checkout");
		}
		}catch(org.openqa.selenium.NoSuchElementException e) {
			log.info("Unable to click on Checkout");
		}
	}
	
	//Validates the product name with respect to the given string
	public void product_Validation(String ele) {
		try {
			if(driver.findElementByXPath("//android.widget.TextView[@text='"+ele+"']").isDisplayed()) {
				log.info(ele+" product name is same as mentioned in the product page");
				
			}
			}catch(org.openqa.selenium.NoSuchElementException e1) {
				log.info("Product name is not same as mentioned in the product page");
				
	}
	}
	
	//Validates the price of product with respect to the parameter price
	public void price_Validation(String price) {
		try {
			if(driver.findElementByXPath("//android.widget.TextView[@text='"+price+"']").isDisplayed()) {
				log.info("Price is same as mentioned in the product page "+price);
				
			}
			}catch(org.openqa.selenium.NoSuchElementException e1) {
				log.info("Bug- Price is not same as mentioned in the product page");
				ScreenshotUtility scrnsht=new ScreenshotUtility(driver);
	 			 try {
					scrnsht.screenshot("Bug-Price mismatch");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
		
		
	}
	
	//Fills the the checkout details and clicks in continue button
	public void fillCheckoutInfo() {
		
		try {
			
		if(driver.findElementByXPath("//android.widget.TextView[@text='CHECKOUT: INFORMATION']").isDisplayed()) {
			log.info("Navigated to Checkout Information Page");
			driver.findElement(MobileBy.AccessibilityId("test-First Name")).sendKeys("Sai Teja");
			driver.findElement(MobileBy.AccessibilityId("test-Last Name")).sendKeys("Voruganti");
			driver.findElement(MobileBy.AccessibilityId("test-Zip/Postal Code")).sendKeys("508206");
			driver.findElement(MobileBy.AccessibilityId("test-CONTINUE")).click();
			log.info("Entered the checkout details");
		}
		}catch(org.openqa.selenium.NoSuchElementException e1) {
			log.info("Issue while navigating to Checkout Information page");
			
		}
	}
	//Checks whether able to navigate checkout overview page or not
	public void checkout_Overview() {
		try {
			
			if(driver.findElementByXPath("//android.widget.TextView[@text='CHECKOUT: OVERVIEW']").isDisplayed()) {
				log.info("Navigated to Checkout Overview Page");
			}
		}catch(org.openqa.selenium.NoSuchElementException e1) {
			log.info("Issue while navigating to Checkout Overview page");
		}	
	}
    
	//Clicks on finish button
	public void clickonFinish() {
		driver.findElement(MobileBy.AccessibilityId("test-FINISH")).click();
	}
	
	//Extracts the order status and displays the status
	public void orderStatus() {
		String orderstatus=driver.findElement(By.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[2]")).getText();
		System.out.println(orderstatus);
		log.info(orderstatus);
	}
	
	//Clicks on back to home button
	public void backtoHome() {
		driver.findElement(MobileBy.AccessibilityId("test-BACK HOME")).click();
	}
	
	//Validates the product details are same in products page and details page
	public void detailPageVerification(int i) throws IOException {
		String HomePageEletext=driver.findElement(By.xpath("(//android.widget.TextView[@content-desc='test-Item title'])["+i+"]")).getText();
		driver.findElement(By.xpath("(//android.widget.TextView[@content-desc='test-Item title'])["+i+"]")).click();
		String Detailpagetext=driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")).getText();
		
         if(HomePageEletext.equals(Detailpagetext)) {
        	 System.out.println(HomePageEletext+" Product Name is same in Home page and Detail Page"); 
             log.info(HomePageEletext+" Product Name is same in Home page and Detail Page");
         }
         else {
        	 System.out.println("Bug: "+HomePageEletext+"- Product Name is not same in Home page and Detail Page");
        	 log.info("Bug: "+HomePageEletext+"- Product Name is not same in Home page and Detail Page");
        	 ScreenshotUtility scrnsht=new ScreenshotUtility(driver);
 			 scrnsht.screenshot("Bug-Mismatch of Product Details");
         }
		
	}
	//Removes an element from the cart based on the index num
	public void removeFromCart(int num) {
		String ele="(//android.view.ViewGroup[@content-desc='test-REMOVE'])[";
		String strend="]";
		String i=String.valueOf(num);
		String Combined=ele.concat(i).concat(strend);
		try {
			
		if(driver.findElement(MobileBy.xpath(Combined)).isDisplayed()) {
			driver.findElement(MobileBy.xpath(Combined)).click();
			log.info("Product removed successfully from the cart");
		}
		}catch(org.openqa.selenium.NoSuchElementException e) {
			log.info("Unable to perform the action");
			
		}
		
	}
	public int checkoutOverview_PriceVerification() {
		int status=0;
		String productprice=driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='test-Price']/android.widget.TextView")).getText();
	    String itemtotal=driver.findElement(By.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[5]")).getText();
	    String value1=productprice.replaceAll("[^0-9.]", "");
	    String value2=itemtotal.replaceAll("[^0-9.]", "");
	    
	    if(value1.equals(value2)) {
	    	status=1;
	    	log.info("Product price and item value is same");
	    	return status;
	    }else {
	    	ScreenshotUtility scrnsht=new ScreenshotUtility(driver);
	    	log.info("Bug-Product price and Item value is not same");
			 try {
				scrnsht.screenshot("Bug-Product price and Item value is not same");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return status;
	    }
	}
	public void clickon_BacktoProducts() {
		driver.findElement(MobileBy.AccessibilityId("test-BACK TO PRODUCTS")).click();
		
	}
}
