package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Utility.Utility;
import locators.MyLocators;

public class WalletHubAssignmentPage {
	public WebDriver driver;
	int timeInSec = 50;
	
	public WalletHubAssignmentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loginToWalletHub(String username, String password) {
		Utility.explicitWait(driver, timeInSec, MyLocators.getTapOnlogin()).click();
		Utility.explicitWait(driver, timeInSec, MyLocators.getEmailId());
		Utility.explicitWait(driver, timeInSec, MyLocators.getEmailId()).sendKeys(username);
		Utility.explicitWait(driver, timeInSec, MyLocators.getPassword()).sendKeys(password);
		Utility.explicitWait(driver, timeInSec, MyLocators.getUncheckRememberMe()).click();
		Utility.explicitWait(driver, timeInSec, MyLocators.getLogin()).click();
		Utility.explicitWait(driver, timeInSec, MyLocators.getRchedHomepage());   
		System.out.println("Reached Home Page");
	}
	
	public void SubmitRating(String comment) {
		Utility.explicitWait(driver, timeInSec, MyLocators.getNavigateToRating()).click();
		WebElement hoverOnRatng = Utility.explicitWait(driver, timeInSec, MyLocators.getTapOn4Ratng());
		Actions action = new Actions(driver);
		action.moveToElement(hoverOnRatng).click().build().perform();
		Utility.explicitWait(driver, timeInSec, MyLocators.getTapOndrpdwn()).click();
		Utility.explicitWait(driver, timeInSec, MyLocators.getSelectHealthInsurance()).click();
		Utility.explicitWait(driver, timeInSec, MyLocators.getWriteReview()).sendKeys(comment);
		Utility.explicitWait(driver, timeInSec, MyLocators.getSubmitReview()).click();
		Utility.explicitWait(driver, timeInSec, MyLocators.getReviwCnfrmtnPage());
		System.out.println("Able to Submit rating");
	}
	
	public void VerifyYourAddedRating(String expectedCmnt) {
		Utility.implicitlyWait(driver,10);		
		driver.get("https://wallethub.com/profile/");
		Utility.explicitWait(driver, timeInSec, MyLocators.getHoverOnProfile()).click();;
		Utility.explicitWait(driver, timeInSec, MyLocators.getTapOnProfile()).click();
		Utility.explicitWait(driver, timeInSec, MyLocators.getRecmndtns());
		Utility.explicitWait(driver, timeInSec, MyLocators.getGoToLatestFeed()).click();
		WebElement reviewPresent = Utility.explicitWait(driver, timeInSec, MyLocators.getVerifyReviewinFeed());
		Assert.assertEquals(reviewPresent.isDisplayed(), true);
		String commentAdded = Utility.explicitWait(driver, timeInSec, MyLocators.getVerifyTextInReview()).getText();
		Assert.assertEquals(commentAdded, expectedCmnt);
		System.out.println("Your recently added review got added and verified!");
	}
}
