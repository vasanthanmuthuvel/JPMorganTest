package base;

import java.io.IOException;
import java.util.Properties;
import Utils.Configreader;
import Utils.report;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import Utils.Configreader;

public class BaseClass extends report {
	
	public int x=10;
	
	  private static WebDriver driver=null;
	  
	  private String region=null;
		private String name=null;
	  
	/*
	 * public String getRegion() { return region; }
	 * 
	 * 
	 * public void setRegion(String region) { this.region = region; }
	 * 
	 * 
	 * public String getName() { return name; }
	 * 
	 * 
	 * public void setName(String name) { this.name = name; }
	 */
  
	static Configreader config=new Configreader();
	
		public BaseClass() {
			try {
			config.readProp();
			if(config.getprop("browser").equalsIgnoreCase("chrome")){
					System.setProperty("webdriver.chrome.driver", "C:\\Data\\selenium\\chromedriver.exe");
					driver= new ChromeDriver();
					driver.get(getValuefromProperty("url"));
			}
			else {
				System.setProperty("webdriver.gecko.driver", "C:\\Data\\selenium\\geckodriver.exe");
				driver =new FirefoxDriver();
				driver.get(getValuefromProperty("url"));
			}
			driver.manage().window().maximize();
			}catch(Exception e) {
				
			}
		}
	
	
	  public static WebDriver getDriver() { 
		  return driver;
	  
	  }
	  
	 
	  //public void setDriver(WebDriver driver) { this.driver = driver; }
	 
		
		public static String getValuefromProperty(String prop) {
			return config.getprop(prop);
		}
		
		@AfterClass
		public void tearDown() {
			getDriver().quit();
			report.getReports().endTest(report.getTest());
			report.getReports().flush();

		}
		
}
