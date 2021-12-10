package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class ReasonForTravelPage extends Utility {

    public ReasonForTravelPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//main[@role='main']//label")
    ////div[@class='gem-c-radio govuk-radios__item']//label
    List<WebElement> reasonForVisitList;



    public void selectReasonForVisit(String reason){
        for (WebElement selectReason : reasonForVisitList){
          if(selectReason.getText().equalsIgnoreCase(reason)){
              //pmWaitUntilVisibilityOfElementLocated(By.xpath("//main[@role='main']//label"), 50);
              pmClickOnElement(selectReason);
              Reporter.log("Select reason for travelling : " + reason + "<br>" );
              break;
          }
        }

    }

    public void clickNextStepButton(){
        pmWaitUntilVisibilityOfElementLocated(By.xpath("(//button[normalize-space()='Continue'])[1]"), 50);
        pmClickOnElement(continueButton);

    }
}
