package pageobject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import reusable.WebDriverHelper;
import uistore.Testcase1Ui;
import utility.ExtentReport;
import utility.Logs;

public class Testcase1 {

	public WebDriver driver;
	public WebDriverHelper webDriver;
	public ExtentReport exReport;
	public Logs logs = new Logs();

	public Testcase1(WebDriver driverr, WebDriverHelper webDriverr, ExtentReport exReportt) {
		driver = driverr;
		webDriver = webDriverr;
		exReport = exReportt;
		logs.createLogger(HomePage.class);
	}
	public void ourProductsContains(String product) throws IOException {
		exReport.enterInfoLog("Check the product in the list "+product);
		logs.enterInfoLog("Check if product is found "+product);
		List<WebElement> arr = webDriver.getMultipleText(driver, Testcase1Ui.ourProducts);
		boolean contains = false;
		for(WebElement element : arr) {
			if(element.getText().contains(product)) {
				exReport.enterPassLogWithSnap(product+" is in the 'our products' list");
				logs.enterInfoLog(product+" is in the 'our products' list");
				contains = true;
				break;
			}
		}
		if(!contains) {
			exReport.enterFailLogWithSnap(product+" is not in the 'our products' list");
			logs.enterInfoLog(product+" is not in the 'our products' list");
		}
	}
}
