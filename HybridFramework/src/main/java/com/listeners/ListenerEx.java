package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;

public class ListenerEx extends BaseClass implements ITestListener {

	

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "test case is failed with name as "+result.getName());
		String path = takeScreenShot(result.getName());
        test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "test case is skipped with name as "+result.getName());
	}

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getName());

		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "test case is passed with name as "+result.getName());

		
	}
    public void onFinish(ITestContext arg0) {
		
	}

	public void onStart(ITestContext arg0) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	}

}
