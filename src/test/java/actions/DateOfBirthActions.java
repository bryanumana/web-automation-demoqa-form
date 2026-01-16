package actions;

import com.microsoft.playwright.Page;
import pages.DateOfBirthPage;
import utilities.AllureUtils;

public class DateOfBirthActions {
    private final Page page;
    private final DateOfBirthPage dateOfBirthPage;

    public DateOfBirthActions(Page page) {
        this.page = page;
        this.dateOfBirthPage = new DateOfBirthPage(page);
    }

    public void inputDateOfBirth(Page page, String month, String year) {
        dateOfBirthPage.dateOfBirthInput().click();
        AllureUtils.debugStepWithScreenshot(page, "Click on Date Of Birth");
        dateOfBirthPage.monthOfBirthInput().selectOption(month);
        AllureUtils.debugStepWithScreenshot(page, "Select month: " + month);
        dateOfBirthPage.yearOfBirthInput().selectOption(year);
        AllureUtils.debugStepWithScreenshot(page, "Select year: " + year);
        dateOfBirthPage.dayOfBirthInput().click();
        AllureUtils.debugStepWithScreenshot(page, "Click on Day");
    }

    public void clearDateOfBirth(Page page) {
        dateOfBirthPage.dateOfBirthInput().clear();
        AllureUtils.debugStepWithScreenshot(page, "Clear on Date Of Birth");
    }

}
