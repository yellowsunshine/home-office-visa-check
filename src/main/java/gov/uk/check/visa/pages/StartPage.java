package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class StartPage extends Utility {

    public StartPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='Start now'])[1]")
    WebElement startNowButton;

    public void clickStartNow(){
        Reporter.log("Clicking on Start " + startNowButton.toString()+ "<br>");
        pmClickOnElement(startNowButton);
    }



}
