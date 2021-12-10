package gov.uk.check.visa.testsuite;


import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VisaConfirmationTest extends TestBase {

    StartPage startPage;
    WorkTypePage workTypePage;
    SelectNationalityPage selectNationalityPage;
    ReasonForTravelPage reasonForTravelPage;
    ResultPage resultPage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;
    DurationOfStayPage durationOfStayPage;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        startPage = new StartPage();
        workTypePage = new WorkTypePage();
        selectNationalityPage = new SelectNationalityPage();
        resultPage = new ResultPage();
        familyImmigrationStatusPage = new FamilyImmigrationStatusPage();
        durationOfStayPage = new DurationOfStayPage();
        reasonForTravelPage = new ReasonForTravelPage();
    }

    @Parameters ({"nationality1", "reason1", "message1"})
    @Test(priority = 1, groups = {"smoke", "regression"})
    public void anAustralianComingToUKForTourism(String nationality, String reason, String expMessage) {
        // Click on start button
        startPage.clickStartNow();
        // Select a Nationality 'Australia'
        selectNationalityPage.selectNationality(nationality);
        // Click on Continue button
        selectNationalityPage.clickNextStepButton();
        // Select reason 'Tourism'
        reasonForTravelPage.selectReasonForVisit(reason);
        // Click on Continue button
        reasonForTravelPage.clickNextStepButton();
        // verify result 'You will not need a visa to come to the UK'
        resultPage.confirmResultMessage(expMessage);
    }

    @Parameters ({"nationality2", "reason2", "message2", "durationOfStay", "planning"})
    @Test(priority = 2, groups = {"sanity", "regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths
            (String nationality, String reason, String expMessage, String time, String plan) {
        // Click on start button
        startPage.clickStartNow();
        // Select a Nationality 'Chile'
        selectNationalityPage.selectNationality(nationality);
        // Click on Continue button
        selectNationalityPage.clickNextStepButton();
        // Select reason 'Work, academic visit or business'
        reasonForTravelPage.selectReasonForVisit(reason);
        // Click on Continue button
        reasonForTravelPage.clickNextStepButton();
        // Select intending to stay for 'longer than 6 months'
        durationOfStayPage.selectLengthOfStay(time);
        // Click on Continue button
        durationOfStayPage.clickNextStepButton();
        // Select have planning to work for 'Health and care professional'
        workTypePage.selectPlanningToWorkType(plan);
        // Click on Continue button
        workTypePage.clickOnContinue();
        // verify result 'You need a visa to work in health and care'
        resultPage.confirmResultMessage(expMessage);

    }

    @Parameters ({"nationality3", "reason3","immigration" ,"message3"})
    @Test(priority = 3, groups = {"regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card
            (String nationality, String reason, String status, String message) {

        //Click on start button
        startPage.clickStartNow();
        //Select a Nationality 'Colombia'
        selectNationalityPage.selectNationality(nationality);
        //Click on Continue button
        selectNationalityPage.clickNextStepButton();
        //Select reason 'Join partner or family for a long stay'
        reasonForTravelPage.selectReasonForVisit(reason);
        //Click on Continue button
        reasonForTravelPage.clickNextStepButton();
        //Select state My partner of family member have uk immigration status 'yes'
        familyImmigrationStatusPage.selectImmigrationStatus(status);
        //Click on Continue button
        familyImmigrationStatusPage.clickNextStepButton();
        //verify result 'You’ll need a visa to join your family or partner in the UK'
        resultPage.confirmResultMessage(message);

    }


}
