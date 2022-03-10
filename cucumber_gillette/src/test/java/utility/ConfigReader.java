package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	static Properties pro;
	static {
		FileInputStream fileStream;
		try {
			fileStream = new FileInputStream("./Test Data/config.properties");
			pro = new Properties();
			pro.load(fileStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getBrowser() {
		return pro.getProperty("browser");
	}

	public static String getUrl() {
		return pro.getProperty("url");
	}

	public static String getExcelPath() {
		return pro.getProperty("excelPath");
	}

	public static String getReportsConfig() {
		return pro.getProperty("reportsConfig");
	}

	public static String getReportsPath() {
		return pro.getProperty("reportsPath");
	}

	public static String getScreenshotPath() {
		return pro.getProperty("screenshotPath");
	}

	public static String getBrowser(String browser) {
		return pro.getProperty(browser);
		
	}
}
