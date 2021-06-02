package locators;

import org.openqa.selenium.By;

public class MyLocators {
	private static By TapOnlogin = By.xpath(".//span[contains(@class,'signup-login')]");
	private static By EmailId = By.name("em");
	private static By Password = By.name("pw");
	private static By uncheckRememberMe = By.xpath(".//label[@role='checkbox']");
	private static By Login = By.xpath("//button[contains(@class,'btn blue')]");
	private static By RchedHomepage = By.xpath(".//div[@class='profile-header-module profile-comp-header']//div[@class='profile-info']");
	private static By navigateToRating = By.xpath("//div[contains(@class,'review-action')]/h3");
	private static By tapOn4Ratng = By.xpath("(//div[contains(@class,'review-action')]//div[@class='rating-box-wrapper']//*[name()='svg'])[4]");
	private static By tapOndrpdwn = By.xpath(".//div[@class='dropdown second']");
	private static By selectHealthInsurance = By.xpath(".//div[@class='dropdown second opened']//ul/li[@class='dropdown-item' and text()='Health Insurance']");
	private static By writeReview = By.xpath("//textarea[contains(@class,'user-input validate')]");
	private static By submitReview = By.xpath("//div[contains(@class,'sbn-action')]");
	private static By ReviwCnfrmtnPage = By.xpath("//main[@review-confirmation]//h2");
	private static By HoverOnProfile = By.xpath(".//div[contains(@class,'user brgm-list-box')]");
	private static By tapOnProfile = By.xpath(".//*[text()='Profile']");
	private static By recmndtns = By.xpath("//section[contains(@class,'pr-rec')]/h2");
	private static By goToLatestFeed = By.xpath("//section[contains(@class,'pr-rec')]//a");
	private static By verifyReviewinFeed = By.xpath(".//article[@itemprop='review']//span[text()='@unknowntesting604']");
	private static By verifyTextInReview = By.xpath(".//article[@itemprop='review']//span[text()='@unknowntesting604']/../../..//div[@itemprop='description']");

	public static By getTapOnlogin() {  return TapOnlogin;  }
	public static By getEmailId() {  return EmailId;  }
	public static By getPassword() {  return Password;  }
	public static By getUncheckRememberMe() {  return uncheckRememberMe;  }
	public static By getLogin() {  return Login;  }
	public static By getRchedHomepage() {  return RchedHomepage;  }
	public static By getNavigateToRating() {  return navigateToRating;  }
	public static By getTapOn4Ratng() {   return tapOn4Ratng;   }
	public static By getTapOndrpdwn() {   return tapOndrpdwn;   }
	public static By getSelectHealthInsurance() {  return selectHealthInsurance;  }
	public static By getWriteReview() {  return writeReview;  }
	public static By getSubmitReview() {  return submitReview;  }
	public static By getReviwCnfrmtnPage() {  return ReviwCnfrmtnPage;  }
	public static By getHoverOnProfile() {  return HoverOnProfile;  }
	public static By getTapOnProfile() {  return tapOnProfile;  }
	public static By getRecmndtns() {  return recmndtns;  }
	public static By getGoToLatestFeed() {  return goToLatestFeed;  }
	public static By getVerifyReviewinFeed() {  return verifyReviewinFeed;  }
	public static By getVerifyTextInReview() {  return verifyTextInReview;  }
}