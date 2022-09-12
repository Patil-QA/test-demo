package com.qa.extentreports;
import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentRep {
	 	private static ExtentReports extent;
	 	
	 	public static ExtentReports createReport() {
		 extent=new ExtentReports();
		ExtentSparkReporter sparkFail=new ExtentSparkReporter("./test-output/RegressionPassed.html");
		sparkFail.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();//for adding fail tc only
		
		ExtentSparkReporter sparkAll=new ExtentSparkReporter("./test-output/RegressionFailed.html");//for all tc details
		
		
		extent.setSystemInfo("Application", "E-commerce Domain");
		extent.setSystemInfo("Environment", "SQA");
		extent.setSystemInfo("Group", "Regression Testing");
		extent.setSystemInfo("Tester", "Kishor Kere");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browser", "Chrome");
		
		
		sparkAll.config().setDocumentTitle("E-Commerce Domain Project E2E Automation Testing");
		sparkAll.config().setReportName("Demoblaze_Regression Testing");
		sparkAll.config().setTheme(Theme.DARK);
		sparkAll.viewConfigurer().viewOrder()
		.as(new ViewName[] {
				   ViewName.TEST, 
				   ViewName.CATEGORY, 
				   ViewName.AUTHOR, 
				   ViewName.DEVICE, 
				   ViewName.EXCEPTION, 
				   ViewName.LOG,
				   ViewName.DASHBOARD}).apply();
		//changing report view order
	
		sparkFail.config().setDocumentTitle("E-Commerce Domain Project E2E Automation Testing");
		sparkFail.config().setReportName("Demoblaze_Regression Testing");
		sparkFail.config().setTheme(Theme.DARK);
		//spark.config().setTimeStampFormat("yyyy.MM.dd HH.mm.ss.SSS");
		
		
		
		
		
		
		extent.attachReporter(sparkFail,sparkAll);
		
		return extent;
		
	 	}
	 	
	 	
	 	
	 	
	 	
	 	
//	 	static{
//		test=extent.createTest("Verify HomePage","This test case validate the functionality of Homepage");
//		test.log(Status.INFO, "Navigated to Homepage");
//		test.warning("Taking time to load the page");
//		test.pass("Test case passed");
//		test.assignCategory("Sanity");
//		test.assignAuthor("Kishor");
//		
//		test=extent.createTest("Login with valid credentials","Checking login functionality");
//		test.log(Status.INFO,"Entered UserName");
//		test.skip("Test case skipped");
//		test.assignCategory("Sanity");
//		test.assignAuthor("Kishor");
//		
//		test=extent.createTest("logout Exception! <i class='fa fa-frown-o'></i>","Check logout functionality");
//		test.log(Status.INFO, "Navigated to logout page");
//		//test.fail(new RuntimeException("Test Failed"));
//		test.log(Status.FAIL,new RuntimeException("Test Failed") );
//		test.addScreenCaptureFromPath("C:\\Users\\DELL\\Desktop\\IMG20200724085742.jpg");
//		test.fail("Screenshot of Failed TC", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\DELL\\Desktop\\IMG20200724085742.jpg").build());
//		//test.addScreenCaptureFromBase64String("Test", "Failed");
//		test.assignCategory("Regression");
//		test.assignAuthor("Rahul");
//		
//		test=extent.createTest("Demoblaze","Launch URL");
//		test.assignAuthor("Kishor");
//		test.log(Status.INFO, "Opening the URL");
//		test.log(Status.INFO, "URL Opened");
//		test.pass("Test Passed");
//		test.assignCategory("Regression");
//		
//		test=extent.createTest("Amazon","Launch URL");
//		test.assignAuthor("Rahul");
//		test.log(Status.INFO, "Opening the URL");
//		test.log(Status.INFO, "URL Opened");
//		test.pass("Test Passed");
//		test.assignCategory("Regression");
//			
//		extent.flush();
//		System.out.println("Kishor");
//
//	}

}
