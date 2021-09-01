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
import com.swaglabs.utility.BaseClass;

public class Verify_Product_Checkoutpage {
	
	public static AppiumDriver<MobileElement> driver;
	public static Logger log =Logger.getLogger("Verify_Product_Checkoutpage.class");
	
	@BeforeTest()
	public void applaunch() {
		driver=com.swaglabs.utility.BaseClass.setUp();

	}
	@Test(priority=0)
	public void product_Checkout_Validation() throws IOException {
		driver=BaseClass.setUp();
		Login login=new Login(driver);
		login.clickonLogin("problem_user","secret_sauce");
		log.info("Logging in with Problem_User credentials");
		Add_Remove_Cart add=new Add_Remove_Cart(driver);
		add.add_ToCart(2);
		add.detailPageVerification(2);
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