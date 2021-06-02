package extentReports;

import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;
	private static ExtentTest test;
	private static ExtentHtmlReporter htmlReporter;
	private static String currentDir = System.getProperty("user.dir");
	private static String filePath = currentDir+"/Reports/";
	private static String startTime = date(); //System.currentTimeMillis();
	static InetAddress ip;
    static String version;
    
	
	public static ExtentReports GetExtent(){
		FindSysProp();
		if (extent != null)
			return extent; //avoid creating new instance of html file
		extent = new ExtentReports();
		extent.setSystemInfo("Environment", "Test");		
		extent.setSystemInfo("Operating System", "OS X For Mac");	
		extent.setSystemInfo("Java Version", version);
		extent.setSystemInfo("Author", "Gaurav");
		extent.attachReporter(getHtmlReporter());
		return extent;
	}

	private static ExtentHtmlReporter getHtmlReporter() {
		htmlReporter = new ExtentHtmlReporter(filePath+"WalletHub_"+startTime+".html");
		htmlReporter.start();
		htmlReporter.config().setDocumentTitle("Wallet Hub Automation report");
		htmlReporter.config().setReportName("Validation Of Review Functionality");
		htmlReporter.config().setAutoCreateRelativePathMedia(true);
		htmlReporter.config().setCSS("css-string");
		htmlReporter.config().setJS("js-string");
		htmlReporter.config().setProtocol(Protocol.HTTPS);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		htmlReporter.config().setCSS("css-string");
		return htmlReporter;
	}
	public static ExtentTest createTest(String name, String description){
		test = extent.createTest(name, description);
		return test;
	}
	
	public static void FindSysProp(){	
    try {
        version = System.getProperty("java.version");       
    } catch (Exception e) {

        e.printStackTrace();
    }
	}
	
	public static String getIpAddress(byte[] rawBytes) {
        int i = 4;
        String ipAddress = "";
        for (byte raw : rawBytes)
        {
            ipAddress += (raw & 0xFF);
            if (--i > 0)
            {
                ipAddress += ".";
            }
        }
        return ipAddress;
    }
	
	public static String date(){
		DateFormat dateformat = new SimpleDateFormat("EEE d MMM yyyy HH:mm:ss Z");
		Date oDate = new Date();
		String date = dateformat.format(oDate);	
		return date;
	}
}