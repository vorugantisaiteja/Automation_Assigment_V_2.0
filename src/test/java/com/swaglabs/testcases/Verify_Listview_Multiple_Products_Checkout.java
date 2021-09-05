package com.swaglabs.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.swaglabs.page.Add_Remove_Cart;
import com.swaglabs.page.Login;
import com.swaglabs.page.Product_Page;
import com.swaglabs.utility.Scroll;
import com.swaglabs.utility.WaitUtility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;


public class Verify_Listview_Multiple_Products_Checkout {
	public static AppiumDriver<MobileElement> driver;
	public static Logger log =Logger.getLogger("Verify_Gridview_Checkout.class");
	Login login=new Login(driver);
	Product_Page menu=new Product_Page(driver);
	Add_Remove_Cart add=new Add_Remove_Cart(driver);
	Product_Page pr=new Product_Page(driver);
	Scroll s=new Scroll(driver);
	WaitUtility w=new WaitUtility(driver);
	
	//App launches
	@BeforeTest()
	public void applaunch() {
		driver=com.swaglabs.utility.BaseClass.setUp();

	}
	@Test(priority=0)
    public void listview_MultipleProducts_Checkout() throws IOException {
		log.info("Starting listview_MultipleProducts_Checkout Scenario");
		
		//Scrolls down in the login page
		s.scrollDown();
		
		/*Taps on the specified element so that credentials will be auto filled to placeholder 
		and clicks on login button*/
		login.tapToAutoFill("standard_user");
		
		//Clicks on Grid/List view toggle button
		menu.clickon_Toogle_List_Grid();
		
		//Finding the details of the products that needs to be added to the cart
		String product1=menu.get_Product_Name(1);
		String productprice1=menu.get_Product_Price(1);
		String product2=menu.get_Product_Name(3);
		String productprice2=menu.get_Product_Price(3);
		
		//Adding the products to the cart
		add.add_ToCart(1);
		add.add_ToCart(2);
		
		/*Displays the cart status and displays the count of the 
		products which are there in the cart if it is not empty*/
		add.cart_status();
		add.gotoCart();
		
		add.product_Validation(product1);
		add.price_Validation(productprice1);
		add.product_Validation(product2);
    	add.price_Validation(productprice2);
		
		//Scrolls until the desired element and clicks if the element is found and clicks on defined element
		s.scroll_UntilElementFound("CHECKOUT");
		
		/*After clicking on checkout button, validates whether 
		navigated to checkout information and fills the details 
		once it navigates to checkout information page*/
		add.fillCheckoutInfo();
		
		/*After completing checkinformation filling, 
		again validates the product details and 
		validates whether navigated to checkout overview page*/		
		add.checkout_Overview();
		
		/* After Validation, scrolls until finish button is found
		 and once it is displayed and performs click operation */
		s.scroll_UntilElementFound("FINISH");		
        
		/*After clicking on finish button, checks for the order 
		status and navigates back to home page */
		add.orderStatus();
		add.backtoHome();
		
		/*Navigates to menu and checks for the logout option 
		and clicks on logout option*/
		menu.clickon_LogoutOption();
		log.info("End of Verify_Listview_Multiple_Products_Checkout");
	}
	
	//After the execution of the test cases, driver quit function is called.
	@AfterTest()
	public void teardown() {
		//Implicit wait function
		w.implicitwait();
        log.info("Driver Quit");
		driver.quit();
	}
	
	

}
