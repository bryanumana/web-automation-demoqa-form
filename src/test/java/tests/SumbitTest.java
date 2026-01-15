package tests;

import actions.SumbitActions;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import utilities.BaseTests;

public class SumbitTest extends BaseTests {

    @Test
    public void submitForm(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        sumbitActions.clickSubmit(page);
    }
}
