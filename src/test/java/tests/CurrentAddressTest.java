package tests;

import actions.CurrentAddressActions;
import actions.SumbitActions;
import com.microsoft.playwright.Page;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import utilities.BaseTests;
import utilities.Logs;

public class CurrentAddressTest extends BaseTests {
    private final Faker faker = new Faker();
    private String currentAddress = faker.address().fullAddress();

    @Test
    public void fillCurrentAddress(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        CurrentAddressActions currentAddressActions = new CurrentAddressActions(page);

        Logs.info("Test: fillCurrentAddress");

        currentAddressActions.fillCurrentAddress(currentAddress);
        sumbitActions.clickSubmit(page);

        currentAddressActions.fillCurrentAddressSuccess();
    }

    @Test
    public void noFillCurrentAddress(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        CurrentAddressActions currentAddressActions = new CurrentAddressActions(page);

        Logs.info("Test: noFillCurrentAddress");

        currentAddressActions.fillCurrentAddress("");
        sumbitActions.clickSubmit(page);

        currentAddressActions.fillCurrentAddressFailed();
    }
}
