package com.GenericLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Listener implements ITestListener {
	
	private ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\Reports.html");
	private ExtentReports extentReports = new ExtentReports();
	//public ExtentTest logger;
	
	public static  ThreadLocal<ExtentTest> logger= new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
	    // not implemented
		
		extentReports.attachReporter(reporter);
		//logger.createTest(result.getName().toString());
	  }

	  /**
	   * Invoked each time a test succeeds.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS
	   */
	  public void onTestSuccess(ITestResult result) {
	    // not implemented
		  String name=null;
		  WebDriver driver;
		  Object obj=result.getInstance();
		  Class clazz=result.getTestClass().getRealClass();
		 try {
			driver=(WebDriver) clazz.getDeclaredField("chromeDriver").get(obj);
			  
			  if(result.getStatus()==ITestResult.SUCCESS) {
				 name= ReUsableMethods.takeScreenshot(driver, result.getName());
				 
				 logger.get().addScreenCaptureFromPath(name,result.getName().toString());
			  }
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	  }

	  /**
	   * Invoked each time a test fails.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#FAILURE
	   */
	  public void onTestFailure(ITestResult result) {
	    // not implemented
	  }

	  /**
	   * Invoked each time a test is skipped.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SKIP
	   */
	  public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

	  /**
	   * Invoked each time a method fails but has been annotated with successPercentage and this failure
	   * still keeps it within the success percentage requested.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
	   */
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	  /**
	   * Invoked each time a test fails due to a timeout.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   */
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	  /**
	   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt; tag
	   * and calling all their Configuration methods.
	   */
	  public void onStart(ITestContext context) {
	    // not implemented
		  
		 
		  logger.set(extentReports.createTest(context.getName().toString()));
		 
		//  logger.createTest(context.getName().toString());
	  }

	  /**
	   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have run
	   * and all their Configuration methods have been called.
	   */
	  public void onFinish(ITestContext context) {
	    // not implemented
		  
		  extentReports.flush();
		  
		  System.out.println(" Reports are Genered Successfully");
		  
		  
		  
	  }

}
