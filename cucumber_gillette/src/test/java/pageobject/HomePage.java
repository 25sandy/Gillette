package pageobject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import reusable.WebDriverHelper;
import uistore.HomePageUi;
import utility.BaseClass;
import utility.ExtentReport;
import utility.Logs;

public class HomePage extends BaseClass {
	public WebDriver driver;
	public WebDriverHelper webDriver;
	public ExtentReport exReport;
	public Logs logs = new Logs();

	public HomePage(WebDriver driverr, WebDriverHelper webDriverr, ExtentReport exReportt) {
		driver = driverr;
		webDriver = webDriverr;
		exReport = exReportt;
		logs.createLogger(HomePage.class);
	}

	public void searchItem(String product) throws InterruptedException, IOException {
		exReport.enterInfoLog("Searching for " + product);
		logs.enterInfoLog("Searching for " + product);
		webDriver.clickElement(driver, HomePageUi.searchIcon);
		if (!webDriver.getText(driver, HomePageUi.searchBox).equals(null))
			webDriver.clearText(driver, HomePageUi.searchBox);
		webDriver.sendText(driver, HomePageUi.searchBox, product, Keys.ENTER);
		Thread.sleep(1500);
//		if (webDriver.getPageTitle(driver).contains("Search")) {
//			exReport.enterPassLogWithSnap("Results for " + product + " is displayed");
//			logs.enterInfoLog("Results for " + product + " is displayed");
//		} else {
//			exReport.enterFailLogWithSnap("Search failed");
//			logs.enterInfoLog("Search failed");
//		}
	}

	public void hoverAndClick(String pageTitle, By visibleOption, By dropdownOption)
			throws InterruptedException, IOException {
		exReport.enterInfoLog("Hovering on 'Products' and clicking on 'MOCH3'");
		logs.enterInfoLog("Hovering on 'Products' and clicking on 'MOCH3'");
		webDriver.hover(driver, visibleOption, dropdownOption);
		if (webDriver.getPageTitle(driver).toLowerCase().contains(pageTitle.toLowerCase())) {
			exReport.enterPassLogWithSnap("Clicking page as opened");
			logs.enterInfoLog("Clicking page as opened");
		} else {
			exReport.enterFailLogWithSnap("Wrong page as opened");
			logs.enterInfoLog("Wrong page as opened");
		}
	}
	 public static  WebDriver startApp(WebDriver driver,String browserName) throws IOException {
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\mindtreedec142\\Desktop\\selenium\\selenium1\\chromedriver.exe");
	       driver=new ChromeDriver();
		}
		else if(browserName.equals("FireFox")) {
			System.setProperty("webdriver.firefox.driver","C:\\Users\\mindtreedec142\\Desktop\\selenium\\Hybrid_Framework\\Drivers\\geckodriver.exe");
		       driver=new FirefoxDriver();
				driver.manage().window().maximize();
			}
			
		else {
			System.out.println("The driver is not found");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
		 
	 }

//	public void mobileClick(String pageTitle, By menu, By option1, By option2, By option3)
//			throws InterruptedException, IOException {
//		exReport.enterInfoLog("Clicking on 'Automotive' ,'Car' and clicking on 'Car Lights'");
//		logs.enterInfoLog("Clicking on 'Automotive' ,'Car' and clicking on 'Car Lights'");
//		webDriver.clickElement(driver, menu);
//		Thread.sleep(500);
//		webDriver.clickElement(driver, option1);
//		Thread.sleep(500);
//		webDriver.clickElement(driver, option2);
//		Thread.sleep(500);
//		webDriver.clickElement(driver, option3);
//		Thread.sleep(500);
//		if (webDriver.getPageTitle(driver).toLowerCase().contains(pageTitle.toLowerCase())) {
//			exReport.enterPassLogWithSnap("Clicking page as opened");
//			logs.enterInfoLog("Clicking page as opened");
//		} else {
//			exReport.enterFailLogWithSnap("Wrong page as opened");
//			logs.enterInfoLog("Wrong page as opened");
//		}
//	}

//	public void clickOnProduct() throws InterruptedException {
//		exReport.enterInfoLog("Clicking on the product link in footer");
//		logs.enterInfoLog("Clicking on the product link in footer");
//		webDriver.clickElement(driver, HomePageUi.footerProductLink);
//		webDriver.switchTab(driver, 1);
//		exReport.enterPassLog("product page is opened in another tab");
//		logs.enterInfoLog("product page is opened in another tab");
//	}

}
