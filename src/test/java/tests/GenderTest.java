package tests;

import actions.GenderActions;
import actions.SumbitActions;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import utilities.BaseTests;
import utilities.Logs;

public class GenderTest extends BaseTests {

    @Test
    public void selectGenderMale(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        GenderActions genderActions = new GenderActions(page);

        Logs.info("Test: selectGenderMale");

        genderActions.selectGenderMale(page);
        sumbitActions.clickSubmit(page);

        genderActions.selectGenderSuccess();
    }

    @Test
    public void selectGenderFemale(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        GenderActions genderActions = new GenderActions(page);

        Logs.info("Test: selectGenderFemale");

        genderActions.selectGenderFemale(page);
        sumbitActions.clickSubmit(page);

        genderActions.selectGenderSuccess();
    }

    @Test
    public void selectGenderOther(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        GenderActions genderActions = new GenderActions(page);

        Logs.info("Test: selectGenderOther");

        genderActions.selectGenderOther(page);
        sumbitActions.clickSubmit(page);

        genderActions.selectGenderSuccess();
    }

    @Test
    public void noSelectGender(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        GenderActions genderActions = new GenderActions(page);

        Logs.info("Test: noSelectGender");
        
        sumbitActions.clickSubmit(page);

        genderActions.selectGenderFailed();
    }
}
