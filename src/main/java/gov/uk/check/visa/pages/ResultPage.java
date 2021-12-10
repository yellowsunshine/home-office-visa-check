package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ResultPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id='result-info']//div[@data-module='track-results' and @data-flow-name='check-uk-visa']//h2[@class='gem-c-heading gem-c-heading--font-size-27 govuk-!-margin-bottom-6']")
    WebElement resultMessage;

    public ResultPage() {
        PageFactory.initElements(driver, this);
    }


    public String getResultMessage(){

        String result = pmGetTextFromElement(resultMessage);

        return result;
    }

    public void confirmResultMessage(String expectedMessage){

        if (getResultMessage().equalsIgnoreCase(expectedMessage)){
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

    }

}

