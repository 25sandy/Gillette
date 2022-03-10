package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageobject.HomePage;
import pageobject.Testcase1;
import pageobject.Testcase2;
import reusable.WebDriverHelper;

public class BaseClass {

	public WebDriver driver;
	public WebDriverHelper webDriver;
	
	public String browser;
	public ExtentReport exReport;
	public Logs logs;
	public HomePage home;
	public Testcase2 productp;
	public Testcase1 moch3;
	

	public void required() throws IOException {
		webDriver = new WebDriverHelper();
		logs = new Logs();

	}

	public void driverSetUp(String browse) throws IOException {
		browser = browse;
		if (ConfigReader.getBrowser(browser).contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (ConfigReader.getBrowser(browser).equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		webDriver.implicitWait(driver, 10);
		exReport = new ExtentReport(driver);
		logs.createLogger(BaseClass.class);
		home = new HomePage(driver, webDriver, exReport);
		productp = new Testcase2(driver, webDriver, exReport);
		moch3 = new Testcase1(driver, webDriver, exReport);
		

	}

	public void driverExit() throws IOException {
		exReport.flush();
		driver.quit();
	}

//	public void driverSetUp(String browse, int width, int height) throws IOException {
//		browser = browse;
//		if (ConfigReader.getBrowser(browser).contains("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
//			driver = new ChromeDriver();
//		} else if (ConfigReader.getBrowser(browser).equals("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
//			driver = new FirefoxDriver();
//		}
//		Dimension dimensions = new Dimension(width, height);
//		driver.manage().window().setSize(dimensions);
//		webDriver.implicitWait(driver, 10);
//		exReport = new ExtentReport(driver);
//		logs.createLogger(BaseClass.class);
//		home = new HomePage(driver, webDriver, exReport);
//		product = new ProductPage(driver, webDriver, exReport);
//	}

}
