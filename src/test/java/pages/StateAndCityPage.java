package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class StateAndCityPage {
    private final Page page;
    private final Locator btnState;
    private final Locator btnStateInput;
    private final Locator btnCity;
    private final Locator btnCityInput;

    public StateAndCityPage(Page page) {
        this.page = page;
        this.btnState = page.locator("#state");
        this.btnStateInput = page.locator("#react-select-3-input");
        ;
        this.btnCity = page.locator("#city");
        this.btnCityInput = page.locator("#react-select-4-input");
        ;
    }

    public Locator stateButton() {
        return btnState;
    }

    public Locator stateInput() {
        return btnStateInput;
    }

    public Locator cityButton() {
        return btnCity;
    }

    public Locator cityInput() {
        return btnCityInput;
    }

}
