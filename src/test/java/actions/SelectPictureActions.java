package actions;

import com.microsoft.playwright.Page;
import pages.SelectPicturePage;
import utilities.AllureUtils;

import java.nio.file.Path;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SelectPictureActions {
    private final Page page;
    private final SelectPicturePage selectPicturePage;

    public SelectPictureActions(Page page) {
        this.page = page;
        this.selectPicturePage = new SelectPicturePage(page);
    }

    public void validatePictureIsVisible(Page page) {
        try {
            assertThat(selectPicturePage.fileButton()).isVisible();
        } catch (AssertionError e) {
            AllureUtils.errorStepWithScreenshot(page, "Select Picture button is not checked");
            throw e;
        }
    }

    public void selectPicture(Page page, Path photoPath) {
        validatePictureIsVisible(page);
        selectPicturePage.fileButton().setInputFiles(photoPath);
        AllureUtils.debugStepWithScreenshot(page, "Select picture: " + photoPath.getFileName().toString());
    }

    public void selectPictureFailed() {
        selectPicturePage.fileButton().inputValue().isEmpty();
        AllureUtils.errorStepWithScreenshot(page, "Select picture is empty");

    }
}
