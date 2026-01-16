package tests;

import actions.DateOfBirthActions;
import actions.SumbitActions;
import annotations.Bug;
import com.microsoft.playwright.Page;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import utilities.BaseTests;
import utilities.Logs;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateOfBirthTest extends BaseTests {
    private final Faker faker = new Faker();
    String month = Month.of(faker.number().numberBetween(1, 13))
            .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    String year = String.valueOf(faker.number().numberBetween(1900, 2101));

    @Test
    public void selectDateOfBirth(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        DateOfBirthActions dateOfBirthActions = new DateOfBirthActions(page);

        Logs.info("Test: selectDateOfBirth");

        dateOfBirthActions.inputDateOfBirth(page, month, year);
        sumbitActions.clickSubmit(page);
    }

    @Test
    @Bug
    public void clearDateOfBirth(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        DateOfBirthActions dateOfBirthActions = new DateOfBirthActions(page);

        Logs.info("Test: selectDateOfBirth");

        dateOfBirthActions.clearDateOfBirth(page);
        sumbitActions.clickSubmit(page);
    }
}
