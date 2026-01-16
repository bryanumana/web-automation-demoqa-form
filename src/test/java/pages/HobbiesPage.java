package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HobbiesPage {
    private final Page page;
    private final Locator cbSports;
    private final Locator cbReading;
    private final Locator cbMusic;

    public HobbiesPage(Page page) {
        this.page = page;
        this.cbSports = page.locator("label[for='hobbies-checkbox-1']");
        this.cbReading = page.locator("label[for='hobbies-checkbox-2']");
        this.cbMusic = page.locator("label[for='hobbies-checkbox-3']");
    }

    public Locator sportsCheckbox() {
        return cbSports;
    }

    public Locator readingCheckbox() {
        return cbReading;
    }

    public Locator musicCheckbox() {
        return cbMusic;
    }
}
