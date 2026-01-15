package tests;

import actions.NameActions;
import actions.SumbitActions;
import com.microsoft.playwright.Page;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import utilities.BaseTests;
import utilities.Logs;

public class NameTest extends BaseTests {
    private final Faker faker = new Faker();
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();

    @Test
    public void fillFirstNamefillLastName(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        NameActions nameActions = new NameActions(page);

        Logs.info("Test: fillFirstNamefillLastName");

        nameActions.fillFirstName(firstName);
        nameActions.fillLastName(lastName);

        sumbitActions.clickSubmit(page);

        nameActions.fillFirstNameSuccess();
        nameActions.fillLastNameSuccess();
    }

    @Test
    public void noFillFirstNamefillLastName(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        NameActions nameActions = new NameActions(page);

        Logs.info("Test: noFillFirstNamefillLastName");

        nameActions.fillFirstName("");
        nameActions.fillLastName(lastName);

        sumbitActions.clickSubmit(page);

        nameActions.fillFirstNameFailed();
        nameActions.fillLastNameSuccess();
    }

    @Test
    public void fillFirstNameNoFillLastName(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        NameActions nameActions = new NameActions(page);

        Logs.info("Test: fillFirstNameNoFillLastName");

        nameActions.fillFirstName(firstName);
        nameActions.fillLastName("");

        sumbitActions.clickSubmit(page);

        nameActions.fillFirstNameSuccess();
        nameActions.fillLastNameFailed();
    }

    @Test
    public void noFillFirstNameNoFillLastName(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        NameActions nameActions = new NameActions(page);

        Logs.info("Test: noFillFirstNameNoFillLastName");

        nameActions.fillFirstName("");
        nameActions.fillLastName("");

        sumbitActions.clickSubmit(page);

        nameActions.fillFirstNameFailed();
        nameActions.fillLastNameFailed();
    }

}
