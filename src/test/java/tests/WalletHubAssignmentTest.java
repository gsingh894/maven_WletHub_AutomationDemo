package tests;

import org.testng.annotations.Test;

import Utility.ExcelDataConfig;
import baseclass.Baseclass;
import pages.WalletHubAssignmentPage;

public class WalletHubAssignmentTest extends Baseclass{
	
	WalletHubAssignmentPage WltHbp;
	String[][] loginData, postFeedData;
	String FilePath = "src/test/resources/testData/Login_data.xlsx";
	
	@Test
	public void executeTestScenarios() throws Exception {
		WltHbp = new WalletHubAssignmentPage(driver);
		String workingDirectory = System.getProperty("user.dir");
		String absoluteFilePath = workingDirectory + "/" + FilePath; 
		ExcelDataConfig config = new ExcelDataConfig(absoluteFilePath);
		loginData = config.getDatafromExcel("Login", 0);
		WltHbp.loginToWalletHub(loginData[0][0], loginData[0][1]);
		postFeedData = config.getDatafromExcel("PostFeed", 0);
		WltHbp.SubmitRating(postFeedData[0][0]);
		WltHbp.VerifyYourAddedRating(postFeedData[0][0]);
	}
	
}