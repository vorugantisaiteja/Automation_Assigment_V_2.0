package com.swaglabs.testcases;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.swaglabs.page.Add_Remove_Cart;
import com.swaglabs.page.Login;
import com.swaglabs.utility.Scroll;
import com.swaglabs.utility.WaitUtility;

import org.apache.log4j.Logger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import com.aventstack.extentreports.ExtentReports;
import com.swaglabs.page.*;


public class Verify_Gridview_Checkout extends com.swaglabs.utility.BaseClass{
	public static AppiumDriver<MobileElement> driver;
	public static Logger log =Logger.getLogger("Verify_Gridview_Checkout.class");

	
	//App Launches
	@BeforeTest()
	public void applaunch() {
		
		driver=com.swaglabs.utility.BaseClass.setUp();
		
	}
	
	/*	After launching the app from the product Grid view page adds a product to the cart 
	and performs checkout operation cart. Followed by logout from the application*/
	@Test(priority=0)
	public void Checkout() throws IOException {
	log.info("Starting Verify_Gridview_Checkout Scenario");
	Login login=new Login(driver);
	
	//Login with valid credentials
	login.clickonLogin("standard_user","secret_sauce");
	Product_Page menu=new Product_Page(driver);
	Add_Remove_Cart add=new Add_Remove_Cart(driver);
	
	//Extracting the product details of the product
	String product=driver.findElement(MobileBy.xpath("(//android.widget.TextView[@content-desc='test-Item title'])[1]")).getText();
	String productprice=driver.findElement(MobileBy.xpath("(//android.widget.TextView[@content-desc='test-Price'])[1]")).getText();
	
	//Calling a Descending order sort function
	menu.desc_sort();
	Scroll s=new Scroll(driver);
	
	//Scrolling till the element found and followed by click operation
	s.scroll_UntilElementFound(product);
	s.scroll_UntilElementFound("ADD TO CART");
	
	//cart_status function will display the status of the cart whether it is empty or not, 
	//and if it not empty will display the number of products available in the cart
	add.cart_status();
	
	//goto_cart() method performs navigation to the cart
	add.gotoCart();
	
	//product details are validated in the cart page
	add.product_Validation(product);
	add.price_Validation(productprice);
	
	// Clicks on Checkout button
	add.checkout();
	
	//Fills checkout information
	add.fillCheckoutInfo();
	
	//product details are validated and checks whether navigated to checkout overview page
	add.product_Validation(product);
	add.price_Validation(productprice);
	add.checkout_Overview();
	
	//scrolls till the Finish button is displayed and performs click operation
	s.scroll_UntilElementFound("FINISH");		

	
	//Order status will be displayed after clicking on finish button
	add.orderStatus();
	
	//Once order confirmation is displayed and navigates back to home page
	add.backtoHome();
	
	//navigates to menu and clicks on logout option
	menu.clickon_LogoutOption();
	log.info("End of Verify_Gridview_Checkout Scenario");
}
	
	//After the execution of the test cases, driver quit function is called.
	@AfterTest()
	public void teardown() {
		WaitUtility w=new WaitUtility(driver);
		w.implicitwait();
        log.info("Driver Quit");
		driver.quit();

}

}
