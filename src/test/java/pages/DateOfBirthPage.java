package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DateOfBirthPage {
    private final Page page;
    private final Locator btnDate;
    private final Locator btnMonth;
    private final Locator btnYear;
    private final Locator btnDay;

    public DateOfBirthPage(Page page) {
        this.page = page;
        this.btnDate = page.locator("#dateOfBirthInput");
        this.btnMonth = page.locator(".react-datepicker__month-select");
        this.btnYear = page.locator(".react-datepicker__year-select");
        this.btnDay = page.locator("div[aria-label*='1st']").nth(0);
    }

    public Locator dateOfBirthInput() {
        return btnDate;
    }

    public Locator monthOfBirthInput() {
        return btnMonth;
    }

    public Locator yearOfBirthInput() {
        return btnYear;
    }

    public Locator dayOfBirthInput() {
        return btnDay;
    }
}
