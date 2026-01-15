package tests;

import actions.EmailActions;
import actions.SumbitActions;
import com.microsoft.playwright.Page;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import utilities.BaseTests;
import utilities.Logs;

public class EmailTest extends BaseTests {
    private final Faker faker = new Faker();
    private String email = faker.internet().emailAddress();

    @Test
    public void fillValidEmail(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        EmailActions emailActions = new EmailActions(page);

        Logs.info("Test: fillValidateEmail");
        emailActions.fillEmail(email);
        sumbitActions.clickSubmit(page);

        emailActions.fillEmailSuccess();
    }

    @Test
    public void fillInvalidEmail(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        EmailActions emailActions = new EmailActions(page);

        Logs.info("Test: fillInvalidateEmail");
        emailActions.fillEmail("correo");
        sumbitActions.clickSubmit(page);

        emailActions.fillEmailFailed();
    }

    @Test
    public void noFillEmail(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        EmailActions emailActions = new EmailActions(page);

        Logs.info("Test: noFillEmail");
        emailActions.fillEmail("");
        sumbitActions.clickSubmit(page);

        emailActions.fillEmailFailed();
    }
}
