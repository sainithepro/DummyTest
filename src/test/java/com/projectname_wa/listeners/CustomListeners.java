package com.projectname_wa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class CustomListeners implements ITestListener{

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed");
		System.out.println("Failed Test Name is: " + result.getName());
		System.out.println(result.getStatus());
		System.out.println("Reason of Error is: " + result.getThrowable().getMessage());
		ExtentTest test = (ExtentTest)result.getAttribute("reporter");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
