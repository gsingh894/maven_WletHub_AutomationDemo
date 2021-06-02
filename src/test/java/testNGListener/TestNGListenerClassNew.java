package testNGListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import extentReports.ExtentManager;

public class TestNGListenerClassNew implements ITestListener {
	ExtentReports extent = ExtentManager.GetExtent();
	ExtentTest test;

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Cases Failed and details are : "+result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Cases Skipped and details are : "+result.getName());
	}

	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.INFO, result.getName());
	}

	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Cases Passed and details are : "+result.getName());	
	}
	
	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
