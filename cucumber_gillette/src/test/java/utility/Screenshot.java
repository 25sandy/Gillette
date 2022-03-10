package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public static String takeScreenshot(WebDriver driver, String browser) throws IOException {
		String path = ConfigReader.getScreenshotPath()+"/"+browser+CurrentDateTime.getDateTime() + ".png";
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(path));
		return path;
	}
	public static String takeScreenshot(WebDriver driver) throws IOException {
		String path = ConfigReader.getScreenshotPath()+"/Screenshot"+CurrentDateTime.getDateTime()+".png";
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(path));
		return path;
	}
}
