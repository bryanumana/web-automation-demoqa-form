package actions;

import com.microsoft.playwright.Page;
import pages.SubjectsPage;
import utilities.AllureUtils;

public class SubjectsActions {
    private final Page page;
    private final SubjectsPage subjectsPage;

    public SubjectsActions(Page page) {
        this.page = page;
        this.subjectsPage = new SubjectsPage(page);
    }

    public void addSubject(Page page, String subjectName) {
        subjectsPage.txtSubjects().click();
        AllureUtils.debugStepWithScreenshot(page, "Click on txtSubjects button");
        subjectsPage.txtSubjects().fill(subjectName);
        page.waitForTimeout(1000);
        page.keyboard().press("Enter");
        AllureUtils.debugStepWithScreenshot(page, "Add subject: " + subjectName);
    }

    public void removeSubject(Page page) {
        subjectsPage.boxSubjects().click();
        AllureUtils.debugStepWithScreenshot(page, "Remove subject");
    }
}
