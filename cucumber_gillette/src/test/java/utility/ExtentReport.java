package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReport {

	ExtentReports report;
	ExtentTest reportLog;
	WebDriver driver;

	public ExtentReport(WebDriver driverr) throws IOException {
		ExtentSparkReporter extent = new ExtentSparkReporter(
				ConfigReader.getReportsPath()+"/Gillette" + CurrentDateTime.getDateTime() + ".html");
		final File config = new File(ConfigReader.getReportsConfig());
		extent.loadXMLConfig(config);
		report = new ExtentReports();
		report.attachReporter(extent);
		driver = driverr;
	}
	
	public void createNewTestReport(String title) {
		reportLog = report.createTest(title);
	}

	public void enterInfoLog(String log) {
		reportLog.info(log);
	}

	public void enterPassLog(String log) {
		reportLog.pass(log);
	}
	
	public void enterPassLogWithSnap(String log) throws IOException {
		reportLog.pass(log,MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.takeScreenshot(driver)).build());
	}

	public void enterFailLog(String log) {
		reportLog.fail(log);
	}
	
	public void enterFailLogWithSnap(String log) throws IOException {
		reportLog.fail(log,MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.takeScreenshot(driver)).build());
	}

	public void flush() {
		report.flush();
	}
}
