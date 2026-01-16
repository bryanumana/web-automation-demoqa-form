package tests;

import actions.StateAndCityActions;
import actions.SumbitActions;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import utilities.BaseTests;
import utilities.Logs;

public class StateAndCityTest extends BaseTests {

    @Test
    public void inputStateAndCity(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        StateAndCityActions stateAndCityActions = new StateAndCityActions(page);

        Logs.info("Test: inputStateAndCity");

        stateAndCityActions.selectState(page);
        stateAndCityActions.inputState(page, "NCR");
        stateAndCityActions.selectCity(page);
        stateAndCityActions.inputCity(page, "Delhi");

        sumbitActions.clickSubmit(page);
    }
}
