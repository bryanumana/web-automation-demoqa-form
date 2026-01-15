package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class GenderPage {
    private final Page page;
    private final Locator rbMale;
    private final Locator rbFemale;
    private final Locator rbOther;

    public GenderPage(Page page) {
        this.page = page;
        this.rbMale = page.locator("label[for='gender-radio-1']");
        this.rbFemale = page.locator("label[for='gender-radio-2']");
        this.rbOther = page.locator("label[for='gender-radio-3']");
    }

    public Locator maleRadio() {
        return rbMale;
    }

    public Locator femaleRadio() {
        return rbFemale;
    }

    public Locator otherRadio() {
        return rbOther;
    }
}
