package com.qa.extentreports;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.extentreports.ExtentRep;



public class ListersReport implements ITestListener  {
	public static Logger log=LogManager.getLogger();
	public static ExtentReports extent=ExtentRep.createReport();
	private static ThreadLocal<ExtentTest> parentTest=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	//public static ExtentTest test;
	public void onTestStart(ITestResult result) {
		  ExtentTest child = parentTest.get().createNode(result.getMethod().getMethodName());
		  test.set(child);
		  log.info(result.getName()+" Test Case Started");
		//test=extent.createTest(null);
		//test.log(Status.INFO, result.getName()+" Started");
		System.out.println("======================================================");
		System.out.println("********"+result.getName()+" Started********");
		System.out.println("======================================================");
	}

	public void onTestSuccess(ITestResult result) {
	 test.get().log(Status.PASS, result.getName()+" Passed");
	 log.info(result.getName()+": Passed");
	 System.out.println("********"+result.getName()+" Passed********");
	}

	public void onTestFailure(ITestResult result) {
	test.get().fail(result.getName()+" Failed");
	test.get().fail(result.getThrowable());
	test.get().addScreenCaptureFromPath("C:\\Users\\DELL\\Downloads\\AutomationFrameworkInBrief_Kishor2.png", "Screenshot of Failed TestCase");
	log.error(result.getName()+" Failed: "+result.getThrowable());
	System.out.println("********"+result.getName()+" Failed********");	
	}

	public void onTestSkipped(ITestResult result) {
		test.get().info(result.getName()+" Skipped");
		test.get().skip(result.getThrowable());
		System.out.println("********"+result.getName()+" Skipped********");		
		log.warn(result.getName()+" Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	public void onStart(ITestContext context) {
		ExtentTest parent=extent.createTest(context.getName());
		parentTest.set(parent);
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		System.out.println("=========On TestSuite Ending=======");
	}

	
	
}
