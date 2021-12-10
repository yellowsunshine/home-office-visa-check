package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FamilyImmigrationStatusPage extends Utility {

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//input[@id='response-0']")
    WebElement yes;

    @FindBy(xpath = "//input[@id='response-1']")
    WebElement no;



    public FamilyImmigrationStatusPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectImmigrationStatus(String status){
        //Note: Use switch statement for select immigration status
        switch (status){
            case "Yes":
                pmClickOnElement(yes);
                break;

            case "No":
                pmClickOnElement(no);
                break;

            default:
                System.out.println("Please select one of the options");
        }


    }

   public void clickNextStepButton(){
        pmClickOnElement(continueButton);


    }


}
