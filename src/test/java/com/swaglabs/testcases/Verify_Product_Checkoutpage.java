package com.swaglabs.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import com.swaglabs.page.Add_Remove_Cart;
import com.swaglabs.page.Login;
import com.swaglabs.page.Product_Page;
import com.swaglabs.utility.BaseClass;
import com.swaglabs.utility.Scroll;
import com.swaglabs.utility.WaitUtility;

public class Verify_Product_Checkoutpage {
	
	public static AppiumDriver<MobileElement> driver;
	public static Logger log =Logger.getLogger("Verify_Product_Checkoutpage.class");
	
	//App launches
	@BeforeTest()
	public void applaunch() {
		driver=com.swaglabs.utility.BaseClass.setUp();

	}
	
	@Test(priority=0)
	public void product_Checkout_Validation() throws IOException {
		driver=BaseClass.setUp();
		Login login=new Login(driver);
		
		//Login with valid credentials
		login.clickonLogin("problem_user","secret_sauce");
		log.info("Logging in with Problem_User credentials");
		Add_Remove_Cart add=new Add_Remove_Cart(driver);
		Product_Page pr=new Product_Page(driver);
		//Adding a product to the cart
		add.add_ToCart(2);
		
		/*Validates the product details by comparing the details present
		 *  in products page to the details present in product details page*/
		add.detailPageVerification(2);
		
		//Clicks on back to product page button
		add.clickon_BacktoProducts();
		
		
	}
	@Test(priority=1)
	public void checkoutOverview() throws IOException {
		int status;
		Login login=new Login(driver);
		Product_Page menu=new Product_Page(driver);
		Add_Remove_Cart add=new Add_Remove_Cart(driver);
		Scroll s=new Scroll(driver);
		
		//Adds product to the cart
		add.add_ToCart(1);
		
		//Checks for the cart status
		add.cart_status();
		
		//Navigates to the cart
		add.gotoCart();
		
		// Clicks on Checkout button
		add.checkout();
		
		//Fills checkout information
		add.fillCheckoutInfo();
		
		 //checks whether navigated to checkout overview page
		add.checkout_Overview();
		
		//This method returns one if the product price and item is same else returns zero
		status=add.checkoutOverview_PriceVerification();
		if(status==1) {
			s.scroll_UntilElementFound("FINISH");
			add.orderStatus();
			add.backtoHome();
			menu.clickon_LogoutOption();
		}
		else {
			
		}
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
