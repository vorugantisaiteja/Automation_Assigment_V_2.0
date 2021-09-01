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

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;


public class Verify_Listview_Multiple_Products_Checkout {
	public static AppiumDriver<MobileElement> driver;
	public static Logger log =Logger.getLogger("Verify_Gridview_Checkout.class");
	
	@BeforeTest()
	public void applaunch() {
		driver=com.swaglabs.utility.BaseClass.setUp();

	}
	@Test(priority=0)
    public void listview_Checkout() throws IOException {
		log.info("Starting Checkout Scenario");
		Login login=new Login(driver);
//		login.clickonLogin("standard_user","secret_sauce");
		Product_Page menu=new Product_Page(driver);
		Add_Remove_Cart add=new Add_Remove_Cart(driver);
		add.scrollDown();
		login.tapToAutoFill("standard_user");
		menu.clickon_Toogle_List_Grid();
		String product1=driver.findElement(MobileBy.xpath("(//android.widget.TextView[@content-desc='test-Item title'])[1]")).getText();
		String productprice1=driver.findElement(MobileBy.xpath("(//android.widget.TextView[@content-desc='test-Price'])[1]")).getText();
		String product2=driver.findElement(MobileBy.xpath("(//android.widget.TextView[@content-desc='test-Item title'])[3]")).getText();
		String productprice2=driver.findElement(MobileBy.xpath("(//android.widget.TextView[@content-desc='test-Price'])[3]")).getText();
		add.add_ToCart(1);
		add.add_ToCart(2);
		Scroll s=new Scroll(driver);		
		add.cart_status();
		add.gotoCart();
		add.product_Validation(product1);
		add.price_Validation(productprice1);
		add.product_Validation(product2);
    	add.price_Validation(productprice2);
		s.scroll_UntilElementFound("CHECKOUT");
		add.fillCheckoutInfo();
		add.product_Validation(product2);
		add.price_Validation(productprice2);
		add.checkout_Overview();
		s.scroll_UntilElementFound("FINISH");		
//		add.clickonFinish();
		add.orderStatus();
		add.backtoHome();
		
		menu.clickon_LogoutOption();
		log.info("End of Verify_Listview_Multiple_Products_Checkout");
	}
	@AfterTest()
	public void teardown() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        log.info("Driver Quit");
		driver.quit();
	}
	
	

}
