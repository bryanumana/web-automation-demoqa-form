package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class EmailPage {
    private final Page page;
    private final Locator txtEmail;

    public EmailPage(Page page) {
        this.page = page;
        this.txtEmail = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("name@example.com"));
    }

    public Locator emailTextBox() {
        return txtEmail;
    }
}
