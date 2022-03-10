package stepDefination;

import java.io.IOException;

import org.junit.runner.RunWith;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import uistore.HomePageUi;
import utility.BaseClass;
import utility.ConfigReader;

@RunWith(Cucumber.class)
public class HoverOperation extends BaseClass {

	@When("user hovers on products MACH is displayed and click on the link")
	public void user_hovers_on_products_MOCH_is_displayed_and_click_on_the_link()
			throws InterruptedException, IOException {
		exReport.createNewTestReport("Click on 'MACH3' in Hover Menu");
		home.hoverAndClick("MACH3", HomePageUi.products, HomePageUi.moch3);
	}

	@Then("check if {string} is present in our products")
	public void verify_if_is_present_in_our_products(String product) throws IOException {
		exReport.createNewTestReport("Verify if " + product + " present in Products");
		moch3.ourProductsContains(product);
	}

	@Given("Initialize the {string} browser")
	public void initialize_the_browser(String browser) throws IOException {
		required();
		driverSetUp(browser);
	}

	@Then("navigate to {string} website")
	public void navigate_to_website(String url) {
		exReport.createNewTestReport("Open Gillette");
		webDriver.openPage(driver, url);
		if (webDriver.getCurrentUrl(driver).equals(ConfigReader.getUrl())) {
			exReport.enterInfoLog("Gillette as opened");
			logs.enterInfoLog("Gillette as opened");
		} else {
			exReport.enterPassLog("Gillette didn't open");
		}
	}

	@Then("exit the browser")
	public void exit_the_browser() throws IOException {
		driverExit();
	}


}
