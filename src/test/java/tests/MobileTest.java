package tests;

import actions.MobileActions;
import actions.SumbitActions;
import com.microsoft.playwright.Page;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import utilities.BaseTests;
import utilities.Logs;

public class MobileTest extends BaseTests {
    private final Faker faker = new Faker();
    private String mobileNumerElevenDigits = faker.number().digits(11);
    private String mobileNumerTenDigits = faker.number().digits(10);
    private String mobileNumerNineDigits = faker.number().digits(9);

    @Test
    public void fillValidMobileTenDigits(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        MobileActions mobileActions = new MobileActions(page);

        Logs.info("Test: fillValidMobileTenDigits");

        mobileActions.fillMobile(mobileNumerTenDigits);
        sumbitActions.clickSubmit(page);

        mobileActions.fillMobileSuccess();
    }

    @Test
    public void fillValidMobileElevenDigits(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        MobileActions mobileActions = new MobileActions(page);

        Logs.info("Test: fillValidMobileElevenDigits");

        mobileActions.fillMobile(mobileNumerElevenDigits);
        sumbitActions.clickSubmit(page);

        mobileActions.fillMobileSuccess();
    }

    @Test
    public void fillValidMobileNineDigits(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        MobileActions mobileActions = new MobileActions(page);

        Logs.info("Test: fillValidMobileNineDigits");

        mobileActions.fillMobile(mobileNumerNineDigits);
        sumbitActions.clickSubmit(page);

        mobileActions.fillMobileFailed();
    }

    @Test
    public void noFillMobile(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        MobileActions mobileActions = new MobileActions(page);

        Logs.info("Test: noFillMobile");

        mobileActions.fillMobile("");
        sumbitActions.clickSubmit(page);

        mobileActions.fillMobileFailed();
    }
}
