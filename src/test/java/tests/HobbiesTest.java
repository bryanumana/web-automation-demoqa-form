package tests;

import actions.HobbiesActions;
import actions.SumbitActions;
import annotations.Bug;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import utilities.BaseTests;
import utilities.Logs;

public class HobbiesTest extends BaseTests {

    @Test
    public void selectHobbiesSportsReadingMusic(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        HobbiesActions hobbiesActions = new HobbiesActions(page);

        Logs.info("Test: selectHobbiesSportsReadingMusic");

        hobbiesActions.selectHobbieSports(page);
        hobbiesActions.selectHobbieReading(page);
        hobbiesActions.selectHobbieMusic(page);
        sumbitActions.clickSubmit(page);

        hobbiesActions.selectHobbiesSuccess();
    }

    @Test
    public void selectHobbiesSportsReading(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        HobbiesActions hobbiesActions = new HobbiesActions(page);

        Logs.info("Test: selectHobbiesSportsReading");

        hobbiesActions.selectHobbieSports(page);
        hobbiesActions.selectHobbieReading(page);
        sumbitActions.clickSubmit(page);

        hobbiesActions.selectHobbiesSuccess();
    }

    @Test
    public void selectHobbiesSportsMusic(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        HobbiesActions hobbiesActions = new HobbiesActions(page);

        Logs.info("Test: selectHobbiesSportsMusic");

        hobbiesActions.selectHobbieSports(page);
        hobbiesActions.selectHobbieMusic(page);
        sumbitActions.clickSubmit(page);

        hobbiesActions.selectHobbiesSuccess();
    }

    @Test
    public void selectHobbiesSports(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        HobbiesActions hobbiesActions = new HobbiesActions(page);

        Logs.info("Test: selectHobbiesSports");

        hobbiesActions.selectHobbieSports(page);
        sumbitActions.clickSubmit(page);

        hobbiesActions.selectHobbiesSuccess();
    }

    @Test
    public void selectHobbiesMusic(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        HobbiesActions hobbiesActions = new HobbiesActions(page);

        Logs.info("Test: selectHobbiesMusic");

        hobbiesActions.selectHobbieMusic(page);
        sumbitActions.clickSubmit(page);

        hobbiesActions.selectHobbiesSuccess();
    }

    @Test
    public void selectHobbiesReading(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        HobbiesActions hobbiesActions = new HobbiesActions(page);

        Logs.info("Test: selectHobbiesReading");

        hobbiesActions.selectHobbieReading(page);
        sumbitActions.clickSubmit(page);

        hobbiesActions.selectHobbiesSuccess();
    }

    @Test
    public void selectHobbiesReadingMusic(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        HobbiesActions hobbiesActions = new HobbiesActions(page);

        Logs.info("Test: selectHobbiesReadingMusic");

        hobbiesActions.selectHobbieReading(page);
        hobbiesActions.selectHobbieMusic(page);
        sumbitActions.clickSubmit(page);

        hobbiesActions.selectHobbiesSuccess();
    }

    @Test
    @Bug
    public void noSelectHobbies(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        HobbiesActions hobbiesActions = new HobbiesActions(page);

        Logs.info("Test: noSelectHobbies");

        sumbitActions.clickSubmit(page);

        hobbiesActions.selectHobbiesFailed();
    }

}
