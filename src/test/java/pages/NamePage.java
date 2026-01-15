package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class NamePage {
    private final Page page;
    private final Locator txtFirstName;
    private final Locator txtLastName;

    public NamePage(Page page) {
        this.page = page;
        this.txtFirstName = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name"));
        this.txtLastName = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name"));
    }

    public Locator firstNameTxtBox() {
        return txtFirstName;
    }

    public Locator lastNameTxtBox() {
        return txtLastName;
    }
}
