package com.MakeMyTrip.GenericLibraries;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is fail");
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is fail");
		test.log(Status.SKIP, result.getThrowable());		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		report=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReport/extentReport.html");
		spark.config().setDocumentTitle("MakeMyTrip");
		spark.config().setReportName("MakeMyTrip Report");
		spark.config().setTheme(Theme.DARK);
		report.attachReporter(spark);
		report.setSystemInfo("Environment","TestNG Environment");
		report.setSystemInfo("Reporter Name","Smitha.S");
		report.setSystemInfo("Platform","Windows 8.1");
		report.setSystemInfo("Unit Testing Tool","TestNG");
		report.setSystemInfo("Build Management Tool","Maven");
		report.setSystemInfo("Automation","Selenium");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
	}

}
