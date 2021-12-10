package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.security.KeyFactory;
import java.util.List;

public class WorkTypePage extends Utility {

    public WorkTypePage(){
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//main[@role='main']//label")
    List<WebElement> planningToWorkTypes;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;
    public void selectPlanningToWorkType(String workType){
        for(WebElement work : planningToWorkTypes){
            if(work.getText().equalsIgnoreCase(workType)){
                pmClickOnElement(work);
                Reporter.log("Select Planning to work : "+workType+"<br>");
            }
        }
    }
    public void clickOnContinue(){
        Reporter.log("Clicking on continue : "+continueButton+"<br>");
        pmClickOnElement(continueButton);
    }
}


