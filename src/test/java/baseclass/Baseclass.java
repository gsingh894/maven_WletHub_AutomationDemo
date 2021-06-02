package baseclass;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utility.Utility;
import extentReports.ExtentManager;

public class Baseclass {
	public static WebDriver driver;
	private static String browserType;
	private static String appurl;
	public static long startTime=System.currentTimeMillis();
	public ExtentReports extent;
	ExtentTest test;

	public static String getBrowserType() {
		return browserType;
	}

	public static String getAppurl() {
		return appurl;
	}

	private void setDriver(String browser, String appURL) throws MalformedURLException {
			driver = initChromeDriver(appURL);
			System.out.println("Chrome Driver initialization has done.");
	}
	//initialize the Chrome Browser in mac.
	private static WebDriver initChromeDriver(String appURL) throws MalformedURLException {
		System.out.println("Launching google chrome with new profile..");	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extensions"); 
		driver = new ChromeDriver(options);
		Utility.implicitlyWait(driver,10);		
		driver.get(appURL);		
		return driver;
	}
	
	//this method is the starting point of this class and send the browser type and app URl to setDriver method.
	
	@BeforeClass
	@Parameters({ "browserType", "appURL" })
	public void initializeTestBaseSetup(String browserType, String appURL) {
		Baseclass.browserType=browserType;
		Baseclass.appurl = appURL;
		try {
			setDriver(browserType, appURL);
		} catch (Exception e)	{
			System.out.println("Error : "+e);
			e.getStackTrace();
		}
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception
	{
		extent = ExtentManager.GetExtent();
		test = ExtentManager.createTest(result.getName(), "");
		if(result.getStatus() == ITestResult.FAILURE)
		{
			//MarkupHelper is used to display the output in different colors
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			String screenshotPath = Utility.TakeScreenshot(driver, result.getName());
			test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));

		}
		else if(result.getStatus() == ITestResult.SKIP){
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
		} 
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
		}
		extent.flush();
	}
	
	//close the respective driver.
	@AfterSuite
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		Utility.totalExecutionTime();
		driver.quit();
		System.out.println("Driver has closed.");

	}
}
