package Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class report {
	
	private static ExtentTest test;
	private static ExtentReports reports;
	
	public report() {
		setReports(new ExtentReports(System.getProperty("user.dir")+"\\target\\ExtentReportResults.html"));
		setTest(getReports().startTest("J.P.Morgan Demo"));
	}

	public static ExtentTest getTest() {
		return test;
	}

	public static void setTest(ExtentTest test) {
		report.test = test;
	}

	public static ExtentReports getReports() {
		return reports;
	}

	public static void setReports(ExtentReports reports) {
		report.reports = reports;
	}
	
	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/../Screenshots/" + System.currentTimeMillis()
		+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
		}
}
