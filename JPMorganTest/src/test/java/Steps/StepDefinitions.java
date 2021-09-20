package Steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import Utils.report;
import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;

public class StepDefinitions extends BaseClass{
	WebDriver driver;
	
	SearchPage searchpage=new SearchPage(getDriver());
	
	@Given("Im on the Google Home Page")
	public void im_on_the_Google_Home_Page() throws IOException {
		if(getDriver().getTitle().equalsIgnoreCase("Google")){
			report.getTest().log(LogStatus.PASS, "Search J.P.Morgan in Google");
			report.getTest().log(LogStatus.PASS,report.getTest().addScreenCapture(report.capture(getDriver()))+ "Search in Google");
		}else {
			report.getTest().log(LogStatus.FAIL, "Search J.P.Morgan in Google");
			report.getTest().log(LogStatus.FAIL,report.getTest().addScreenCapture(report.capture(getDriver()))+ "Search in Google");
		}
	}
	
	@Given("type J.P.Morgan in the Google Search text box")
	public void type_J_P_Morgan_in_the_Google_Search_text_box() throws InterruptedException, IOException {
		searchpage.searchText(getValuefromProperty("keyWord"));
	}
	
	@Then("I Should see Google Search Results")
	public void i_Should_see_Google_Search_Results() throws IOException {
		
		if(getDriver().getTitle().equalsIgnoreCase("j.p. morgan")){
			report.getTest().log(LogStatus.PASS, "Verified J.P.Morgan Search Result");
			report.getTest().log(LogStatus.PASS,report.getTest().addScreenCapture(report.capture(getDriver()))+ "Verify J.P.Morgan search result");
		}else {
			report.getTest().log(LogStatus.FAIL, "J.P.Morgan search not available");
			report.getTest().log(LogStatus.FAIL,report.getTest().addScreenCapture(report.capture(getDriver()))+ "Verify J.P.Morgan search result");
		}
	
	}
	
	@Then("I click First Result")
	public void i_click_First_Result() throws InterruptedException, IOException {
		searchpage.clickFirstResult();
	}
	
	@Then("I should See J.P.Morgan logo")
	public void i_should_See_J_P_Morgan_logo() throws InterruptedException, IOException {
		searchpage.verifyJPMorganLogo();
	}
	
	@Then("I Close the browser")
	public void i_close_the_browser() throws InterruptedException, IOException {
		getDriver().quit();
		report.getReports().endTest(report.getTest());
		report.getReports().flush();
	}
}
