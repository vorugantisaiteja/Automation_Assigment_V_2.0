package com.swaglabs.testcases;

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
import io.appium.java_client.MobileElement;

public class Verify_DragAndDrop {
	public static AppiumDriver<MobileElement> driver;
	public static Logger log =Logger.getLogger("Verify_Product_Checkoutpage.class");
	
	Login login=new Login(driver);
	Add_Remove_Cart add=new Add_Remove_Cart(driver);
	Scroll s=new Scroll(driver);
	Product_Page menu=new Product_Page(driver);
	WaitUtility w=new WaitUtility(driver);
	
	@BeforeTest()
	public void applaunch() {
		driver=com.swaglabs.utility.BaseClass.setUp();

	}
	
	@Test(priority=0)
	public void dragAndDrop_product() {
		s.scrollDown();
		login.tapToAutoFill("standard_user");
		
		//Dragging a product and dropping in the cart
		add.dragAndDrop();
		
		//Checking the cart status and navigating to the cart
		add.cart_status();
		add.gotoCart();
		
		//swiping from right to left
		s.scroll_RightToLeft();
		
		//after swiping from right to left delete button is clicked
		add.clickon_DeleteIcon();
		
		
		//Clicks on continue shopping
		add.clickon_ContinueShopping();
		
		//checking the cart status
	    add.cart_status();
		
		
		//clicks on logout
		menu.clickon_LogoutOption();
		
		
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
