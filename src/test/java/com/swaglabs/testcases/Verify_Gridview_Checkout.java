package com.swaglabs.testcases;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.swaglabs.page.Add_Remove_Cart;
import com.swaglabs.page.Login;
import com.swaglabs.utility.Scroll;

import org.apache.log4j.Logger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import com.swaglabs.page.*;


public class Verify_Gridview_Checkout extends com.swaglabs.utility.BaseClass{
	public static AppiumDriver<MobileElement> driver;
	public static Logger log =Logger.getLogger("Verify_Gridview_Checkout.class");
	
	@BeforeTest()
	public void applaunch() {
		driver=com.swaglabs.utility.BaseClass.setUp();

	}
	@Test(priority=0)
	public void Checkout() throws IOException {
	log.info("Starting Checkout Scenario");
	Login login=new Login(driver);
	login.clickonLogin("standard_user","secret_sauce");
	Product_Page menu=new Product_Page(driver);
	Add_Remove_Cart add=new Add_Remove_Cart(driver);
	String product=driver.findElement(MobileBy.xpath("(//android.widget.TextView[@content-desc='test-Item title'])[1]")).getText();
	String productprice=driver.findElement(MobileBy.xpath("(//android.widget.TextView[@content-desc='test-Price'])[1]")).getText();
	menu.desc_sort();
	Scroll s=new Scroll(driver);
	s.scroll_UntilElementFound(product);
	s.scroll_UntilElementFound("ADD TO CART");
//	add.add_ToCart(1);
	add.cart_status();
	add.gotoCart();
	add.product_Validation(product);
	add.price_Validation(productprice);
	add.checkout();
	add.fillCheckoutInfo();
	add.product_Validation(product);
	add.price_Validation(productprice);
	add.checkout_Overview();
	s.scroll_UntilElementFound("FINISH");		
	add.clickonFinish();
	add.orderStatus();
	add.backtoHome();
	
	menu.clickon_LogoutOption();
	log.info("End of checkout Scenario");
}
}
