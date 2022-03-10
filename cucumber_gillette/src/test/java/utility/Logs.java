package utility;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

public class Logs {

	Logger log;

	public void createLogger(Class presentClass) {
		log = Logger.getLogger(presentClass);
	}

	public void enterInfoLog(String logMsg) {
		log.info(logMsg);
	}

	public void enterErrorLog(String logMsg) {
		log.error(logMsg);
	}

	public void enterDebugLog(String logMsg) {
		log.debug(logMsg);
	}

	public Logger createLog(String name) {
		log = Logger.getLogger(name);
		Date d = new Date(0);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH/mm/SS");
		String date = sdf.format(d);
		String timeStamp = date.replace("", "_").replaceAll(":", "_").replaceAll("/", "_");
		System.setProperty("timeStamp", timeStamp);
		BasicConfigurator.resetConfiguration();
		PropertyConfigurator.configure("log4j.properties");
		Logger log1 = Logger.getLogger("fremarker.cache");
		log1.setAdditivity(false);
		return log;
	}
}
