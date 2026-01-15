package tests;

import actions.SumbitActions;
import annotations.PruebaExitosa;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import net.datafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import utilities.AllureUtils;
import utilities.BaseTests;
import utilities.Logs;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class ExampleTest extends BaseTests {
    private final Faker faker = new Faker();

    @Test
    public void fillNameAndLastName(Page page) {

        Logs.info("Escribiendo el First Name");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name"))
                .fill(faker.name().firstName());
        AllureUtils.infoStepWithScreenshot(page, "Diligenciando el First Name");

        Logs.info("Escribiendo el Last Name");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name"))
                .fill(faker.name().lastName());
        AllureUtils.infoStepWithScreenshot(page, "Diligenciando el Last Name");

    }

    @Test
    public void fillEmail(Page page) {

        Logs.info("Escribiendo el Email");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("name@example.com"))
                .fill(faker.internet().emailAddress());
        AllureUtils.infoStepWithScreenshot(page, "Escribiendo el Email");
    }

    @Test
    public void selectGender(Page page) {

        Logs.info("Seleccionando el gender");
        page.locator("label[for='gender-radio-1']").click();
        AllureUtils.infoStepWithScreenshot(page, "Seleccionando el gender");

    }

    @Test
    public void fillMobileNumber(Page page) {

        Logs.info("Escribiendo el Numero Telefono");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Mobile Number"))
                .fill(String.valueOf(faker.number().randomNumber(10)));
        AllureUtils.infoStepWithScreenshot(page, "Escribiendo el Numero Telefono");
    }

    @Test
    @PruebaExitosa
    public void setDateOfBirth(Page page) {
        String month = Month.of(faker.number().numberBetween(1, 13))
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        Logs.info("Seleccionar el campo de texto de la fecha");
        page.locator("#dateOfBirthInput").click();
        AllureUtils.infoStepWithScreenshot(page, "Seleccionar el campo de texto de la fecha");

        Logs.info("Seleccionar el mes");
        page.selectOption(".react-datepicker__month-select", month);
        AllureUtils.infoStepWithScreenshot(page, "Seleccionar el mes");

        Logs.info("Seleccionar el año");
        page.selectOption(".react-datepicker__year-select", String.valueOf(2000));
        AllureUtils.infoStepWithScreenshot(page, "Seleccionar el año");

        Logs.info("Seleccionar el día");
        page.click("div[aria-label*='1st']");
        AllureUtils.infoStepWithScreenshot(page, "Seleccionar el día");
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
        AllureUtils.infoStepWithScreenshot(page, "Seleccionando materias");

    }

    @Test
    public void selectHobbies(Page page) {

        Logs.info("Seleccionando deportes");
        page.locator("label[for='hobbies-checkbox-1']").click();
        AllureUtils.infoStepWithScreenshot(page, "Seleccionando deportes");

        Logs.info("Seleccionando lectura");
        page.locator("label[for='hobbies-checkbox-2']").click();
        AllureUtils.infoStepWithScreenshot(page, "Seleccionando lectura");

        Logs.info("Seleccionando musica");
        page.locator("label[for='hobbies-checkbox-3']").click();
        AllureUtils.infoStepWithScreenshot(page, "Seleccionando musica");

    }

    @Test
    public void uploadPicture(Page page) throws URISyntaxException {

        Logs.info("Subiendo foto");
        URL resourceUrl = getClass().getClassLoader().getResource("files/kenny.jpg");

        if (resourceUrl != null) {
            Path photoPath = Paths.get(resourceUrl.toURI());
            page.locator("#uploadPicture").setInputFiles(photoPath);
        } else {
            Logs.error("Archivo no encontrado");
        }
        AllureUtils.infoStepWithScreenshot(page, "Subiendo foto");
    }

    @Test
    public void fillAddress(Page page) {

        Logs.info("Diligenciar la dirección");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Current Address"))
                .fill(faker.address().streetAddress());
        AllureUtils.infoStepWithScreenshot(page, "Diligenciar la dirección");
    }

    @Test
    public void selectStateAndCity(Page page) {

        Logs.info("Seleccionar el estado");
        page.click("#state");
        page.fill("#react-select-3-input", "NCR");
        page.keyboard().press("Enter");
        AllureUtils.infoStepWithScreenshot(page, "Seleccionar el estado");

        Logs.info("Seleccionar la ciudad");
        page.click("#city");
        page.fill("#react-select-4-input", "Delhi");
        page.keyboard().press("Enter");
        AllureUtils.infoStepWithScreenshot(page, "Seleccionar la ciudad");
    }

    @AfterEach
    public void afterEach(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        sumbitActions.clickSubmit(page);
    }
}
