package utilities;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.BeforeEach;
import pages.SumbitPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UsePlaywright(CustomOptions.class)
public class BaseTests {
    @BeforeEach
    public void beforeEach(Page page) {
        SumbitPage sumbitPage = new SumbitPage(page);
        final var url = "https://demoqa.com/automation-practice-form";
        final var expectedTitle = "Practice Form";


        page.navigate(url);

        try {
            assertThat(page.locator("h1.text-center"))
                    .hasText(expectedTitle);
            AllureUtils.debugStepWithScreenshot(page, "Open website: " + url);
        } catch (AssertionError e) {
            AllureUtils.errorStepWithScreenshot(page, "Error opening page");
            throw e;
        }
    }
}
