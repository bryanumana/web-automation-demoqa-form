package actions;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import pages.GenderPage;
import utilities.AllureUtils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class GenderActions {
    private final Page page;
    private final GenderPage genderPage;

    public GenderActions(Page page) {
        this.page = page;
        this.genderPage = new GenderPage(page);
    }

    public void validateGenderIsVisible(Page page) {
        try {
            assertThat(genderPage.maleRadio()).isVisible();
            assertThat(genderPage.femaleRadio()).isVisible();
            assertThat(genderPage.otherRadio()).isVisible();
        } catch (AssertionError e) {
            AllureUtils.errorStepWithScreenshot(page, "Gender button is not visible");
            throw e;
        }
    }

    public void selectGenderMale(Page page) {
        validateGenderIsVisible(page);
        genderPage.maleRadio().click();
        AllureUtils.debugStepWithScreenshot(page, "Fill Email field: " + "Male");
    }

    public void selectGenderFemale(Page page) {
        validateGenderIsVisible(page);
        genderPage.femaleRadio().click();
        AllureUtils.debugStepWithScreenshot(page, "Fill Email field: " + "Female");
    }

    public void selectGenderOther(Page page) {
        validateGenderIsVisible(page);
        genderPage.otherRadio().click();
        AllureUtils.debugStepWithScreenshot(page, "Fill Email field: " + "Other");
    }

    public void selectGenderSuccess() {
        Boolean isValid =
                genderPage.maleRadio().isChecked()
                        || genderPage.femaleRadio().isChecked()
                        || genderPage.otherRadio().isChecked();
        Assertions.assertTrue(isValid);
    }

    public void selectGenderFailed() {
        Boolean isInvalid =
                !genderPage.maleRadio().isChecked()
                        && !genderPage.femaleRadio().isChecked()
                        && !genderPage.otherRadio().isChecked();
        AllureUtils.errorStepWithScreenshot(page, "Gender button is not checked");
        Assertions.assertTrue(isInvalid);
    }
}
