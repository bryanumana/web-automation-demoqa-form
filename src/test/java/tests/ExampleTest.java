package tests;

import com.microsoft.playwright.Page;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import utilities.AllureUtils;
import utilities.BaseTests;
import utilities.Logs;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class ExampleTest extends BaseTests {
    private final Faker faker = new Faker();
    
    @Test
    public void setDateOfBirth(Page page) {
        String month = Month.of(faker.number().numberBetween(1, 13))
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        Logs.info("Seleccionar el campo de texto de la fecha");
        page.locator("#dateOfBirthInput").click();
        AllureUtils.debugStepWithScreenshot(page, "Seleccionar el campo de texto de la fecha");

        Logs.info("Seleccionar el mes");
        page.selectOption(".react-datepicker__month-select", month);
        AllureUtils.debugStepWithScreenshot(page, "Seleccionar el mes");

        Logs.info("Seleccionar el año");
        page.selectOption(".react-datepicker__year-select", String.valueOf(2000));
        AllureUtils.debugStepWithScreenshot(page, "Seleccionar el año");

        Logs.info("Seleccionar el día");
        page.click("div[aria-label*='1st']");
        AllureUtils.debugStepWithScreenshot(page, "Seleccionar el día");
    }

    @Test
    public void addSubjects(Page page) {
        faker.educator().course();
        Logs.info("Seleccionando materias");
        String[] subjects = {"Math", "Science"};

        for (String subject : subjects) {
            page.locator("#subjectsInput").click();
            page.locator("#subjectsInput").fill(subject);
            page.locator("#subjectsInput").press("Enter");
            page.waitForTimeout(500);
        }
        AllureUtils.debugStepWithScreenshot(page, "Seleccionando materias");

    }

    @Test
    public void selectStateAndCity(Page page) {

        Logs.info("Seleccionar el estado");
        page.click("#state");
        page.fill("#react-select-3-input", "NCR");
        page.keyboard().press("Enter");
        AllureUtils.debugStepWithScreenshot(page, "Seleccionar el estado");

        Logs.info("Seleccionar la ciudad");
        page.click("#city");
        page.fill("#react-select-4-input", "Delhi");
        page.keyboard().press("Enter");
        AllureUtils.debugStepWithScreenshot(page, "Seleccionar la ciudad");
    }
}
