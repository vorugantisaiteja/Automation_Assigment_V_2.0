package com.swaglabs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.swaglabs.utility.Scroll;
import com.swaglabs.utility.WaitUtility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Product_Page extends com.swaglabs.utility.BaseClass{
	
	//Invoking the constructor
	public Product_Page(AppiumDriver<MobileElement> driver) {
		
	}
	
	// Clicks on menu icon
	public void menuClick() {
		WaitUtility w=new WaitUtility(driver);
         try {
        	 //waits until the specified element is accessible
        	 w.until_Element_IsAccessible("test-Menu");
		     driver.findElement(MobileBy.AccessibilityId("test-Menu")).click();
		     log.info("Clicked on Menu icon");
         }catch(org.openqa.selenium.NoSuchElementException e) {
        	 log.info("Unable to click on menu icon");        	 
         }
	}
	
	//Performs all filter actions one by one 
	public void filteractions() {
		desc_sort();
		aesc_sort();
		price_hightolow_sort();
		price_lowtohigh_sort();
		
		
	}
	
	//Sorting with respect to descending order
	public void desc_sort() {
		driver.findElement(MobileBy.AccessibilityId("test-Modal Selector Button")).click();
		String filtertype1=driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Name (Z to A)']")).getText();
		System.out.println("Filtering with respect to "+filtertype1+" filter type");
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Name (Z to A)']")).click();
		afterSorting(filtertype1);
		
	}
	
	//Sorting with respect ascending order
	public void aesc_sort() {
		driver.findElement(MobileBy.AccessibilityId("test-Modal Selector Button")).click();
		String filtertype2=driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Name (A to Z)']")).getText();
		System.out.println("Filtering with respect to "+filtertype2+" filter type");
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Name (A to Z)']")).click();
		afterSorting(filtertype2);
		
	}
	//Sorting with respect price from high to low 
	public void price_hightolow_sort() {
		driver.findElement(MobileBy.AccessibilityId("test-Modal Selector Button")).click();
		String filtertype4=driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Price (high to low)']")).getText();
		System.out.println("Filtering with respect to "+filtertype4+" filter type");
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Price (high to low)']")).click();
		afterSorting(filtertype4);
		
	}
	//Sorting with respect price from low to high
	public void price_lowtohigh_sort() {
		driver.findElement(MobileBy.AccessibilityId("test-Modal Selector Button")).click();
		String filtertype3=driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Price (low to high)']")).getText();
		System.out.println("Filtering with respect to "+filtertype3+" filter type");
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Price (low to high)']")).click();
		afterSorting(filtertype3);
		
	}
	//Displays the products details after sorting
	public void afterSorting(String filtertype) {
		String ProductName1=driver.findElement(MobileBy.xpath("(//android.widget.TextView[@content-desc='test-Item title'])[1]")).getText();
	    String Price1=driver.findElement(MobileBy.xpath("(//android.widget.TextView[@content-desc='test-Price'])[1]")).getText();
	    String ProductName2=driver.findElement(MobileBy.xpath("(//android.widget.TextView[@content-desc='test-Item title'])[2]")).getText();
	    String Price2=driver.findElement(MobileBy.xpath("(//android.widget.TextView[@content-desc='test-Price'])[2]")).getText();
	    System.out.println("-------------------------------------"); 
	    System.out.println("Details after filtering w.r.t "+filtertype);
	    System.out.println(ProductName1 +" "+ Price1);
	    System.out.println(ProductName2 +" "+ Price2);
	    System.out.println("**************************************");
	    System.out.println("");
	    
	    log.info("-------------------------------------"); 
	    log.info("Details after filtering w.r.t "+filtertype);
	    log.info(ProductName1 +" "+ Price1);
	    log.info(ProductName2 +" "+ Price2);
	    log.info("**************************************");
	    log.info("");
	}
	
	//Performs all menu operations
	public void MenuOperations() {
		
		clickon_AllItemsOption();
		clickon_WebViewOption();
		clickon_GeoLocationOption();
		clickon_QRCodeScannerOption();
		clickon_LogoutOption();
	}
	
	//Clicks on all items from menu
	public void clickon_AllItemsOption() {
		menuClick();
		driver.findElement(MobileBy.AccessibilityId("test-ALL ITEMS")).click();
		Scroll s=new Scroll(driver);
		s.scrollDown();
		if(driver.findElementByXPath("//android.widget.TextView[@text='PRODUCTS']").isDisplayed()) {
			System.out.println("All Items are displayed");
			
		}
		
	}
	//Clicks on webview option from menu
	public void clickon_WebViewOption() {
		menuClick();
		driver.findElement(MobileBy.AccessibilityId("test-WEBVIEW")).click();
		if(driver.findElementByXPath("//android.widget.TextView[@text='WEBVIEW SELECTION']").isDisplayed()) {
			System.out.println("Successfully Navigated to WebView Selction Page");
		}
		
	}
	//Clicks on QR code scanner from menu
    public void clickon_QRCodeScannerOption() {
    	menuClick();
		driver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"test-QR CODE SCANNER\"]")).click();
		try {
			
    	if(driver.findElementById("com.android.permissioncontroller:id/permission_allow_button").isDisplayed()) {
    		driver.findElementById("com.android.permissioncontroller:id/permission_allow_button").click();
    		log.info("Successfully Navigated to WebView Selection Page");
    		try {
				
    			if(driver.findElementByXPath("//android.widget.TextView[@text='Scan a QR Code that contains a url.']").isDisplayed()) {
                    System.out.println("QR Code Scanner is launched");				
    			}
        	}catch(org.openqa.selenium.NoSuchElementException e1) {
        		System.out.println("QR Code Scanner is not launched");
        		
        	}
    	}
		}catch(org.openqa.selenium.NoSuchElementException e) {
			try {
				
			if(driver.findElementByXPath("//android.widget.TextView[@text='Scan a QR Code that contains a url.']").isDisplayed()) {
                System.out.println("QR Code Scanner is launched");				
			}
    	}catch(org.openqa.selenium.NoSuchElementException e1) {
    		System.out.println("QR Code Scanner is not launched");
    		
    	}
		}
    }
    
  //Clicks on GeoLocation from menu
    public void clickon_GeoLocationOption() {
    	
    	menuClick();
    	driver.findElement(MobileBy.AccessibilityId("test-GEO LOCATION")).click();
    	try {
			
    		
        	if(driver.findElementById("com.android.permissioncontroller:id/permission_allow_always_button").isDisplayed()) {
        		driver.findElementById("com.android.permissioncontroller:id/permission_allow_always_button").click();
//        		System.out.println("Successfully Navigated to WebView Selction Page");
        		try {
    				
        			if(driver.findElementByXPath("//android.widget.TextView[@text='GEO LOCATION']").isDisplayed()) {
                        System.out.println("Navigated to Geo Location Page");
                        System.out.println("Latitude and Longitude values are displayed");
                        
                        
        			}
            	}catch(org.openqa.selenium.NoSuchElementException e1) {
            		System.out.println("Not Navigated to Geo Location Page");
            		
            	}
        		
        	}
    		}catch(org.openqa.selenium.NoSuchElementException e) {
    			try {
    				
    			if(driver.findElementByXPath("//android.widget.TextView[@text='GEO LOCATION']").isDisplayed()) {
                    System.out.println("Navigated to Geo Location Page");
                    System.out.println("Latitude and Longitude values are displayed");
                    
                    
    			}
        	}catch(org.openqa.selenium.NoSuchElementException e1) {
        		System.out.println("Not Navigated to Geo Location Page");
        		
        	}
    		}
    	
    }
    
  //Clicks on Logout from menu and validates the logout has been successful or not
    public void clickon_LogoutOption() {
		try {
    	    menuClick();
		    driver.findElement(MobileBy.AccessibilityId("test-LOGOUT")).click();
		}
		catch(org.openqa.selenium.NoSuchElementException e1) {
			menuClick();
			driver.findElement(MobileBy.AccessibilityId("test-LOGOUT")).click();
		}
		try {
		if(driver.findElement(MobileBy.AccessibilityId("test-LOGIN")).isDisplayed()) {
			System.out.println("Logged out successfully");
			log.info("Logged out successfully");
			
		}
		}catch(org.openqa.selenium.NoSuchElementException e1) {
			System.out.println("Not Logged out");
			log.info("Not Logged out");
		}
		
	}
    
    //Clicks on List-View/Grid-View toggle button
    public void clickon_Toogle_List_Grid() {
    	try {
    		driver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc='test-Toggle']/android.widget.ImageView")).click();
    	    log.info("Clicked on List-Grid View Toggle button");
    	}catch(org.openqa.selenium.NoSuchElementException e1) {
    		log.info("Not Able to Click on List-Grid View Toggle button");
    		
    	}
    	
    	
    }
    //Extracting product name
    public String get_Product_Name(int num) {
    	String Product_name;
    	Product_name=driver.findElement(MobileBy.xpath("(//android.widget.TextView[@content-desc='test-Item title'])["+num+"]")).getText();
    	return Product_name;
    }
    
    //Extracting product details
    public String get_Product_Price(int num) {
    	String Product_name;
    	Product_name=driver.findElement(MobileBy.xpath("(//android.widget.TextView[@content-desc='test-Price'])["+num+"]")).getText();
    	return Product_name;
    }
}
