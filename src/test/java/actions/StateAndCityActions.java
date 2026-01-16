package actions;

import com.microsoft.playwright.Page;
import pages.StateAndCityPage;
import utilities.AllureUtils;

public class StateAndCityActions {
    private final Page page;
    private final StateAndCityPage stateAndCityPage;

    public StateAndCityActions(Page page) {
        this.page = page;
        this.stateAndCityPage = new StateAndCityPage(page);
    }

    public void selectState(Page page) {
        stateAndCityPage.stateButton().click();
        AllureUtils.debugStepWithScreenshot(page, "Click on State");
    }

    public void inputState(Page page, String state) {
        stateAndCityPage.stateInput().fill(state);
        page.keyboard().press("Enter");
        AllureUtils.debugStepWithScreenshot(page, "Fill State: " + state);
    }

    public void selectCity(Page page) {
        stateAndCityPage.cityButton().click();
        AllureUtils.debugStepWithScreenshot(page, "Click on City");
    }

    public void inputCity(Page page, String city) {
        stateAndCityPage.cityInput().fill(city);
        page.keyboard().press("Enter");
        AllureUtils.debugStepWithScreenshot(page, "Fill City: " + city);
    }

}
