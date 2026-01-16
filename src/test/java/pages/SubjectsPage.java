package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SubjectsPage {
    private final Page page;
    private final Locator txtSubjects;
    private final Locator boxSubjects;

    public SubjectsPage(Page page) {
        this.page = page;
        this.txtSubjects = page.locator("#subjectsInput");
        this.boxSubjects = page.locator(".subjects-auto-complete__multi-value__remove");
    }

    public Locator txtSubjects() {
        return txtSubjects;
    }

    public Locator boxSubjects() {
        return boxSubjects;
    }
}
