package listeners;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.TestBase;
import utilities.ExtentReport;



//import org.testng.internal.annotations.IListeners;

public class Listeners extends TestBase implements ITestListener {
	ExtentReports extent =ExtentReport.getReportObject();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestStart(result);
		
		test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestFailure(result);
		// Screenshot
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;

		String MethodName = result.getMethod().getMethodName();

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Exception e) {

		}

		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshotPath(MethodName,driver), result.getMethod().getMethodName());
						//getScreenshotPath(MethodName,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		// ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		// ITestListener.super.onFinish(context);
		 extent.flush(); 
		 
	}

/*	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		 return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		 return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
	 return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		 return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		// super.finalize();
	}*/

}
