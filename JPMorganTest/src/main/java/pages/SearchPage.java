package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import Utils.report;

public class SearchPage {
	
	 WebDriver driver;
	 
	 @FindBy(xpath = "//input[@name='q']")
	 WebElement txtSearch;
	 
	 @FindBy(xpath="(//h3)[1]")
	 WebElement firstResult;
	 
	 @FindBy(xpath="(//img[@alt='J.P. Morgan logo'])[2]")
	 WebElement logo;

	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void searchText(String val) throws InterruptedException, IOException {
		txtSearch.clear();
		report.getTest().log(LogStatus.PASS, "Search J.P.Morgan in Google");
		report.getTest().log(LogStatus.PASS,report.getTest().addScreenCapture(report.capture(driver))+ "Search in Google");
		txtSearch.sendKeys(val,Keys.ENTER);
	}
	
	public void clickFirstResult() throws InterruptedException, IOException {
		report.getTest().log(LogStatus.PASS, "clicked first Result in Google Search");
		report.getTest().log(LogStatus.PASS,report.getTest().addScreenCapture(report.capture(driver))+ "First Result in Google");
		firstResult.click();

	}
	
	public void verifyJPMorganLogo() throws InterruptedException, IOException {
		WebDriverWait wait=new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(logo)); 
		
		if(logo.isDisplayed()){
			report.getTest().log(LogStatus.PASS, "Verified J.P.Morgan logo");
			report.getTest().log(LogStatus.PASS,report.getTest().addScreenCapture(report.capture(driver))+ "Verify J.P.Morgan");
		}else {
			report.getTest().log(LogStatus.FAIL, "J.P.Morgan logo not available");
			report.getTest().log(LogStatus.FAIL,report.getTest().addScreenCapture(report.capture(driver))+ "Verify J.P.Morgan");
		}
	}
	
}
