package actions;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import pages.HobbiesPage;
import utilities.AllureUtils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HobbiesActions {
    private final Page page;
    private final HobbiesPage hobbiesPage;

    public HobbiesActions(Page page) {
        this.page = page;
        this.hobbiesPage = new HobbiesPage(page);
    }

    public void validateHobbiesIsVisible(Page page) {
        try {
            assertThat(hobbiesPage.sportsCheckbox()).isVisible();
            assertThat(hobbiesPage.readingCheckbox()).isVisible();
            assertThat(hobbiesPage.musicCheckbox()).isVisible();
        } catch (AssertionError e) {
            AllureUtils.errorStepWithScreenshot(page, "Hobbies button is not visible");
            throw e;
        }
    }

    public void selectHobbieSports(Page page) {
        validateHobbiesIsVisible(page);
        hobbiesPage.sportsCheckbox().click();
        AllureUtils.debugStepWithScreenshot(page, "Select Hobbies field: " + "Sports");
    }

    public void selectHobbieReading(Page page) {
        validateHobbiesIsVisible(page);
        hobbiesPage.readingCheckbox().click();
        AllureUtils.debugStepWithScreenshot(page, "Select Hobbies field: " + "Reading");
    }

    public void selectHobbieMusic(Page page) {
        validateHobbiesIsVisible(page);
        hobbiesPage.musicCheckbox().click();
        AllureUtils.debugStepWithScreenshot(page, "Select Hobbies field: " + "Music");
    }

    public void selectHobbiesSuccess() {
        Boolean isValid =
                hobbiesPage.sportsCheckbox().isChecked()
                        || hobbiesPage.readingCheckbox().isChecked()
                        || hobbiesPage.musicCheckbox().isChecked();
        Assertions.assertTrue(isValid);
    }

    public void selectHobbiesFailed() {
        boolean isAnyChecked =
                hobbiesPage.sportsCheckbox().isChecked()
                        || hobbiesPage.readingCheckbox().isChecked()
                        || hobbiesPage.musicCheckbox().isChecked();

        boolean isInvalid = !isAnyChecked;

        AllureUtils.errorStepWithScreenshot(page, "Hobbies button is not checked");
        Assertions.assertTrue(isInvalid);
    }
}
