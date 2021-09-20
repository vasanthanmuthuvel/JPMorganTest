package scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.SearchPage;

public class DriverScriptTest extends BaseClass {

  @Test
  public void mainTest() throws InterruptedException, IOException {
		
		//Search J.P Morgan
		SearchPage search=new SearchPage(getDriver());
		search.searchText(getValuefromProperty("keyWord"));
		search.clickFirstResult();
		search.verifyJPMorganLogo();
  }
}
 
