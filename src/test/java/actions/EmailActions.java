package actions;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import pages.EmailPage;
import utilities.AllureUtils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class EmailActions {
    private final Page page;
    private final EmailPage emailPage;

    public EmailActions(Page page) {
        this.page = page;
        this.emailPage = new EmailPage(page);
    }

    public void validateEmailIsVisible(Page page) {
        try {
            assertThat(emailPage.emailTextBox()).isVisible();
        } catch (AssertionError e) {
            AllureUtils.errorStepWithScreenshot(page, "Email field is not visible");
            throw e;
        }
    }

    public void fillEmail(String email) {
        validateEmailIsVisible(page);
        emailPage.emailTextBox().fill(email);
        AllureUtils.debugStepWithScreenshot(page, "Fill Email field: " + email);
    }

    public void fillEmailSuccess() {
        Boolean isValid = (Boolean) emailPage.emailTextBox()
                .evaluate("el => el.checkValidity()");
        Assertions.assertTrue(isValid);
    }

    public void fillEmailFailed() {
        Boolean isInvalid = (Boolean) emailPage.emailTextBox()
                .evaluate("el => !el.checkValidity()");
        AllureUtils.errorStepWithScreenshot(page, "Email field is wrong");
        Assertions.assertTrue(isInvalid);
    }
}
