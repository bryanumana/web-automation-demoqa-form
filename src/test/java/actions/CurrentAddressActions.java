package actions;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import pages.CurrentAddressPage;
import utilities.AllureUtils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CurrentAddressActions {
    private final Page page;
    private final CurrentAddressPage currentAddressPage;

    public CurrentAddressActions(Page page) {
        this.page = page;
        this.currentAddressPage = new CurrentAddressPage(page);
    }

    public void validateCurrentAddressIsVisible(Page page) {
        try {
            assertThat(currentAddressPage.currentAddressTextArea())
                    .isVisible();
        } catch (AssertionError e) {
            AllureUtils.errorStepWithScreenshot(page, "Current Address is not visible");
            throw e;
        }
    }

    public void fillCurrentAddress(String currentAddress) {
        validateCurrentAddressIsVisible(page);
        currentAddressPage.currentAddressTextArea().fill(currentAddress);
        AllureUtils.debugStepWithScreenshot(page, "Fill Current Address: " + currentAddress);
    }

    public void fillCurrentAddressSuccess() {
        Boolean isValid = (Boolean) currentAddressPage.currentAddressTextArea()
                .evaluate("el => el.checkValidity()");
        Assertions.assertTrue(isValid);
    }

    public void fillCurrentAddressFailed() {
        Boolean isInvalid = (Boolean) currentAddressPage.currentAddressTextArea()
                .evaluate("el => !el.checkValidity()");
        AllureUtils.errorStepWithScreenshot(page, "Current Address is wrong");
        Assertions.assertTrue(isInvalid);
    }
}
