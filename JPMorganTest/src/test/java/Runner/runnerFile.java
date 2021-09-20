package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 

public class runnerFile {
	
	@CucumberOptions(features = "src/test/resources/Features",
					 glue = "Steps",
					 tags="@JPMorgan")
	public class RunTestNGTest extends AbstractTestNGCucumberTests {
	 
	}
}
