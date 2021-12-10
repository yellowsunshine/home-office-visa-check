package gov.uk.check.visa.testbase;

import gov.uk.check.visa.propertyreader.PropertyReader;
import gov.uk.check.visa.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        selectBrowser(browser);
    }


/*

    //test to check framework template has set up successfully
    @Test
    public void test(){
        System.out.println("success");
    }
*/

    @AfterMethod(groups = {"sanity","smoke","regression"})
    public void tearDown(){
        closeBrowser();
    }
}
