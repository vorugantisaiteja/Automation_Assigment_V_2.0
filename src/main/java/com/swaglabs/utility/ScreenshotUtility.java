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
	public ScreenshotUtility(AppiumDriver<MobileElement> driver) {
		
	}
	
	public void screenshot() throws IOException{
		String path_screenshot="C:\\Users\\prade\\eclipse-workspace\\SwagLabs_App_Automation\\src\\main\\utility\\screenshots\\";
	    File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    String filename=UUID.randomUUID().toString(); 
	    File targetFile=new File(path_screenshot + filename +".jpg");
	    FileUtils.copyFile(srcFile,targetFile);
	} }
