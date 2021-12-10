package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SelectNationalityPage extends Utility {

    public SelectNationalityPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//select[@class='govuk-select']")
    WebElement nationalityDropDownList;

    @CacheLookup
    @FindBy(xpath = "(//button[normalize-space()='Continue'])[1]")
    WebElement continueButton;

   public void selectNationality(String nationality){
        Reporter.log("Selecting Nationality " + nationalityDropDownList.toString()+ "<br>");
        pmSelectByVisibleTextFromDropDown(nationalityDropDownList, nationality);
    }

    public void clickNextStepButton(){
        Reporter.log("Clicking continue Button " + continueButton.toString()+ "<br>");
        pmClickOnElement(continueButton);

    }


}
