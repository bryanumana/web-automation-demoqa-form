package actions;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import pages.MobilePage;
import utilities.AllureUtils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MobileActions {
    private final Page page;
    private final MobilePage mobilePage;

    public MobileActions(Page page) {
        this.page = page;
        this.mobilePage = new MobilePage(page);
    }


    public void validateMobileIsVisible(Page page) {
        try {
            assertThat(mobilePage.mobileTextBox()).isVisible();
        } catch (AssertionError e) {
            AllureUtils.errorStepWithScreenshot(page, "Mobile field is not visible");
            throw e;
        }
    }

    public void fillMobile(String mobileNumber) {
        validateMobileIsVisible(page);
        mobilePage.mobileTextBox().fill(mobileNumber);
        AllureUtils.debugStepWithScreenshot(page, "Fill Mobile field: " + mobileNumber);
    }

    public void fillMobileSuccess() {
        Boolean isValid = (Boolean) mobilePage.mobileTextBox()
                .evaluate("el => el.checkValidity()");
        Assertions.assertTrue(isValid);
    }

    public void fillMobileFailed() {
        Boolean isInvalid = (Boolean) mobilePage.mobileTextBox()
                .evaluate("el => !el.checkValidity()");
        AllureUtils.errorStepWithScreenshot(page, "Mobile field is wrong");
        Assertions.assertTrue(isInvalid);
    }
}
