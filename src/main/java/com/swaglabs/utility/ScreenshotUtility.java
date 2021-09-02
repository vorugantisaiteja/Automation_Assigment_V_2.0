package com.swaglabs.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ScreenshotUtility extends BaseClass{
	
	//Invoking the constructor
	public ScreenshotUtility(AppiumDriver<MobileElement> driver) {
		
	}
	
	// Screenshot will be captured and will be stored in the specified path
	public void screenshot(String filename) throws IOException{
		String path_screenshot=System.getProperty("user.dir")+"\\src\\main\\utility\\screenshots\\";
	    File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 
	    File targetFile=new File(path_screenshot + filename +".jpg");
	    FileUtils.copyFile(srcFile,targetFile);
	} }
