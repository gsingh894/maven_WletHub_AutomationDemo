package Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseclass.Baseclass;


public class Utility {
	
	public static String actualPageTitle;
	
	public static String TakeScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String destination = currentDir + "/Screenshots/" + screenshotName + dateName + ".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}
	
	public static String modifyDateLayout(String inputDate) throws ParseException{	
	    String userDateFormat = "MMM dd, yyyy hh:mm:ss a";
	    String dateString = inputDate;	    
	    DateFormat sdf = new SimpleDateFormat(userDateFormat);	   
	    	Date date = sdf.parse(dateString);
	        System.out.println(sdf.format(date));	
	        sdf = new SimpleDateFormat();
	        System.out.println(sdf.format(date) );
	        return sdf.format(date);
	}
	
	public static void totalExecutionTime(){
		long endTime = System.currentTimeMillis();
		long totalTime = (endTime-Baseclass.startTime)/1000;
		System.out.println("Script has executed in "+totalTime+" seconds.");
	}

	public static void waitTillPageLoad(WebDriver driver){
		long timeOut = 30000;
		long end = System.currentTimeMillis() + timeOut;
		while (System.currentTimeMillis() < end) {
			String state=String.valueOf((((JavascriptExecutor)driver).executeScript("return document.readyState")));
			if (state.equalsIgnoreCase("complete")) {
				break;
			}
		}
	}

	public static void implicitlyWait(WebDriver driver, int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static WebElement explicitWait(WebDriver driver,int timeInSec, By locator){
		WebDriverWait wait = new WebDriverWait(driver, timeInSec);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static WebElement explicitWaitForPresence(WebDriver driver,int timeInSec, By locator){
		WebDriverWait wait = new WebDriverWait(driver, timeInSec);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static WebElement explicitWait(WebDriver driver,int timeInSec, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, timeInSec);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void clickElement(WebDriver driver, WebElement element){
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}
}