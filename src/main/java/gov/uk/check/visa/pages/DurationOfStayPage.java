package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.apache.poi.ss.usermodel.charts.ScatterChartSeries;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DurationOfStayPage extends Utility {

    public DurationOfStayPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement nextStepButton;

    @CacheLookup
    @FindBy(xpath = "(//input[@id='response-0'])[1]")
    WebElement lessThanSixMonths;

    @CacheLookup
    @FindBy(xpath = "(//input[@id='response-1'])[1]")
    WebElement moreThanSixMonths;



    public void selectLengthOfStay(String moreOrLess){
    //Note: use switch statement for select moreOrLess stay

        switch (moreOrLess) {
            case "longer than 6 months":
                pmClickOnElement(moreThanSixMonths);
                break;

            case "6 months or less":
                pmClickOnElement(lessThanSixMonths);
                break;
            default:
                System.out.println("Please enter a valid selection");
        }

  }

   public void clickNextStepButton(){
        pmClickOnElement(nextStepButton);


       }
}
