package pageobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import reusable.WebDriverHelper;
import uistore.Testcase2Ui;
import utility.ExtentReport;
import utility.Logs;

public class Testcase2 {

	public WebDriver driver;
	public WebDriverHelper webDriver;
	public ExtentReport exReport;
	public Logs logs = new Logs();

	public Testcase2(WebDriver driverr, WebDriverHelper webDriverr, ExtentReport exReportt) {
		driver = driverr;
		webDriver = webDriverr;
		exReport = exReportt;
		logs.createLogger(Testcase2.class);
	}
	public void checkSearchHeading(String product) throws IOException {
		exReport.enterInfoLog("Checking if the name of the search heading contains '"+product+"'");
		logs.enterInfoLog("Checking if the name of the search heading contains '"+product+"'");
		String heading = "Results For \""+product+"\"";
		if(webDriver.getText(driver, Testcase2Ui.searchHeading).contains(heading)) {
			exReport.enterPassLogWithSnap("The name of the search heading contains '"+product+"'");
			logs.enterInfoLog("The name of the search heading contains '"+product+"'");
		}
	}

//	public String getProductName(By element) {
//		exReport.enterInfoLog("Getting the name of the element from result");
//		logs.enterInfoLog("Getting the name of the element from result");
//		return webDriver.getText(driver, element);
//	}
//
//	public void verifyProduct(String givenName, String productString) throws IOException {
//		exReport.enterInfoLog("Checking if the  product name from result contains " + givenName);
//		logs.enterInfoLog("Checking if the  product name from result contains " + givenName);
//		if (productString.toLowerCase().contains(givenName.toLowerCase())) {
//			exReport.enterPassLogWithSnap("The  product name contains " + givenName);
//			logs.enterInfoLog("The product name contains " + givenName);
//		} else {
//			exReport.enterFailLogWithSnap("The product name does not contain " + givenName);
//			logs.enterInfoLog("The product name does not contain " + givenName);
//		}
//	}
}
