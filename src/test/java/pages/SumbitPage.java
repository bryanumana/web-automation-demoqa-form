package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class SumbitPage {
    private final Page page;
    private final Locator btnSubmit;

    public SumbitPage(Page page) {
        this.page = page;
        this.btnSubmit = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit"));
    }

    public Locator submitButton() {
        return btnSubmit;
    }
}
