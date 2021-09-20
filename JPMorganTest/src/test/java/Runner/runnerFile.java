package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 

public class runnerFile {
	
	@CucumberOptions(features = "src/test/resources/featureFiles", glue = "stepDefinitions")
	public class RunTestNGTest extends AbstractTestNGCucumberTests {
	 
	}
}
