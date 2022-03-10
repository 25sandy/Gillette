package stepDefination;

import java.io.IOException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.BaseClass;
import utility.ConfigReader;

public class SearchOperation extends BaseClass{
	
	@When("searching for {string} in search bar")
	public void searching_for_in_search_bar(String product) throws InterruptedException, IOException {
		exReport.createNewTestReport("Search in Gillette");
		home.searchItem(product);
	}

	@Then("verify if search heading is correct and contains {string}")
	public void verify_if_search_heading_is_correct_and_contains(String product) throws IOException {
		exReport.createNewTestReport("Verify search heading Name");
		productp.checkSearchHeading(product);
	}

	@Then("exit  the browser")
	public void exit_the_browser() throws IOException {
		driverExit();
		
	}
	@Given("Initialize  the {string} browser")
	public void initialize_the_browser(String browser) throws IOException {
		required();
		driverSetUp(browser);
		
	}

	@Then("navigate  to {string} website")
	public void navigate_to_website(String url) throws IOException {
		exReport.createNewTestReport("Open Gillette");
		webDriver.openPage(driver, url);
		if (webDriver.getCurrentUrl(driver).equals(ConfigReader.getUrl())) {
			exReport.enterInfoLog("Gillette as opened");
			logs.enterInfoLog("Gillette as opened");
		} else {
			exReport.enterPassLog("Gillette didn't open");
		}
		
	}

}
