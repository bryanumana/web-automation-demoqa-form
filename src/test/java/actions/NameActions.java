package actions;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import pages.NamePage;
import utilities.AllureUtils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NameActions {
    private final Page page;
    private final NamePage namePage;

    public NameActions(Page page) {
        this.page = page;
        this.namePage = new NamePage(page);
    }


    public void validateNameIsVisible(Page page) {
        try {
            assertThat(namePage.firstNameTxtBox()).isVisible();
            assertThat(namePage.lastNameTxtBox()).isVisible();
        } catch (AssertionError e) {
            AllureUtils.errorStepWithScreenshot(page, "Names field is not visible");
            throw e;
        }
    }

    public void fillFirstName(String firstName) {
        validateNameIsVisible(page);
        namePage.firstNameTxtBox().fill(firstName);
        AllureUtils.debugStepWithScreenshot(page, "Fill First Name field: " + firstName);
    }

    public void fillLastName(String lastName) {
        validateNameIsVisible(page);
        namePage.lastNameTxtBox().fill(lastName);
        AllureUtils.debugStepWithScreenshot(page, "Fill Last Name field: " + lastName);
    }

    public void fillFirstNameSuccess() {
        Boolean isValid = (Boolean) namePage.firstNameTxtBox()
                .evaluate("el => el.checkValidity()");
        Assertions.assertTrue(isValid);
    }

    public void fillLastNameSuccess() {
        Boolean isValid = (Boolean) namePage.lastNameTxtBox()
                .evaluate("el => el.checkValidity()");
        Assertions.assertTrue(isValid);
    }

    public void fillFirstNameFailed() {
        Boolean isInvalid = (Boolean) namePage.firstNameTxtBox()
                .evaluate("el => !el.checkValidity()");
        AllureUtils.errorStepWithScreenshot(page, "First Name field is wrong");
        Assertions.assertTrue(isInvalid);
    }

    public void fillLastNameFailed() {
        Boolean isInvalid = (Boolean) namePage.lastNameTxtBox()
                .evaluate("el => !el.checkValidity()");
        AllureUtils.errorStepWithScreenshot(page, "Last Name field is wrong");
        Assertions.assertTrue(isInvalid);
    }
}
