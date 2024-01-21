package com.neotech.testbase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.neotech.utilities.CommonMethods;

public class Listener implements ITestListener {
	
	//This method will be executed just ONCE at the beginning of the whole TEST!!
	public void onStart(ITestContext context) 
	{
		System.out.println("Functionaility test started");
	}
	
	//This method will be executed just ONCE at the end of the whole TEST!!
	public void onFinish(ITestContext context) 
	{
		System.out.println("Functionaility test finished");
	}
	
	//This method will be executed for each @Test
	public void onTestStart(ITestResult result) 
	{
		System.out.println("Test will Start is : " + result.getName());
		
		//Here, its creating a test on the report, to use it to log into ExtentReports
		BaseClass.test = BaseClass.report.createTest(result.getName());
	}
	
	//This method will be executed for each @Test that passes, if Test passed it will return "Test passed:" and its method name
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("Test Passed is : " + result.getName());
		
		//Here, it will print Test, Passed on the report
		BaseClass.test.pass("Test Passed is : " + result.getName());
		
		//Take a screenshot and ADD it to the Report
		BaseClass.test.addScreenCaptureFromPath(CommonMethods.takeScreenshot("passed/" + result.getName()));
	}
	
	//This method will be executed for each @Test that fails, if Test failed it will return "Test failed:" and its method name
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Test Failed is : " + result.getName());
		
		//Here, it will print Test, Failed on the report
		BaseClass.test.fail("Test Failed is : " + result.getName());
		
		//Take a screenshot and ADD it to the report
		BaseClass.test.addScreenCaptureFromPath(CommonMethods.takeScreenshot("failed/" + result.getName()));
	}

}
