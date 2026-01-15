package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class MobilePage {
    private final Page page;
    private final Locator txtMobileNumber;

    public MobilePage(Page page) {
        this.page = page;
        this.txtMobileNumber = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Mobile Number"));
    }

    public Locator mobileTextBox() {
        return txtMobileNumber;
    }
}
