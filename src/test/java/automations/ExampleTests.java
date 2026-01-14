package automations;

import annotations.PruebaExitosa;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.AllureUtils;
import utilities.BaseTests;
import utilities.Logs;

public class ExampleTests extends BaseTests {
    @Test
    @PruebaExitosa
    public void openTheWebsite(Page page) {
        Logs.info("Abrir página con el navegador");
        page.navigate("https://demoqa.com/automation-practice-form");
        final var url = page.url();
        Assertions.assertEquals("https://demoqa.com/automation-practice-form", url);
        AllureUtils.stepWithScreenshot(page, "Abrir página con el navegador");
    }
}
