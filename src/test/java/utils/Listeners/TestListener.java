package utils.Listeners;

import org.testng.Assert;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.swaglabs.testcases.Verify_Gridview_Checkout;
import com.swaglabs.utility.ScreenshotUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import utils.ExtentReports.ExtentManager;


public class TestListener extends Verify_Gridview_Checkout implements ITestListener  {
    //Extent Report Declarations
    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

    public synchronized void onStart(ITestContext context) {
    System.out.println("*** Test Suite " + context.getName() + " started ***");
    }

    public synchronized void onFinish(ITestContext context) {
    System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
        extent.flush();
    }

    public synchronized void onTestStart(ITestResult result) {
    System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        test.set(extentTest);
    }

    public synchronized void onTestSuccess(ITestResult result) {
    System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
        test.get().pass("Test passed");
        String screenShotPath = null;
        try {
            screenShotPath=ScreenshotUtility.get_ScreenshotPath();   
            } catch (Exception e1) {
                 // TODO Auto-generated catch block 
                 e1.printStackTrace();
            }
         try {
        	 test.get().addScreenCaptureFromPath(screenShotPath);
             } 
         catch (IOException e) {
             System.out.println("An exception occured while taking screenshot " + e.getCause());
            }
    }

    public synchronized void onTestFailure(ITestResult result) {
    System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
        Assert.fail("Test Failed!");
       
    String screenShotPath = null;
    try {
        screenShotPath=ScreenshotUtility.get_ScreenshotPath();   
        } catch (Exception e1) {
             // TODO Auto-generated catch block 
             e1.printStackTrace();
        }
     try {
    	   
    	   Assert.fail("Snapshot below:"+ test.get().addScreenCaptureFromPath(screenShotPath));
         } 
     catch (IOException e) {
         System.out.println("An exception occured while taking screenshot " + e.getCause());
        }
    }

    public synchronized void onTestSkipped(ITestResult result) {
    System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
        test.get().skip(result.getThrowable());
        }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
    }
}