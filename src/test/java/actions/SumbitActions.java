package actions;

import com.microsoft.playwright.Page;
import pages.SumbitPage;
import utilities.AllureUtils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SumbitActions {
    private final Page page;
    private final SumbitPage sumbitPage;

    public SumbitActions(Page page) {
        this.page = page;
        this.sumbitPage = new SumbitPage(page);
    }


    public void validateSubmitButtonIsVisible(Page page) {
        try {
            assertThat(sumbitPage.submitButton())
                    .isVisible();
        } catch (AssertionError e) {
            AllureUtils.errorStepWithScreenshot(page, "SubmitButton is not visible");
            throw e;
        }
    }

    public void clickSubmit(Page page) {
        validateSubmitButtonIsVisible(page);
        sumbitPage.submitButton().click();
        AllureUtils.infoStepWithScreenshot(page, "Click on the button");
    }

}
