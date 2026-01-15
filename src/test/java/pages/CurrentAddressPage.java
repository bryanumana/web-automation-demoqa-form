package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CurrentAddressPage {
    private final Page page;
    private final Locator textareaCurrentAddress;

    public CurrentAddressPage(Page page) {
        this.page = page;
        this.textareaCurrentAddress = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Current Address"));
    }

    public Locator currentAddressTextArea() {
        return textareaCurrentAddress;
    }
}
