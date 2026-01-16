package tests;

import actions.SubjectsActions;
import actions.SumbitActions;
import annotations.Bug;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import utilities.BaseTests;
import utilities.Logs;

public class SubjectsTest extends BaseTests {

    @Test
    public void addOneSubject(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        SubjectsActions subjectsActions = new SubjectsActions(page);

        Logs.info("Test: addOneSubject");
        subjectsActions.addSubject(page, "a");

        sumbitActions.clickSubmit(page);
    }

    @Test
    public void addManySubject(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        SubjectsActions subjectsActions = new SubjectsActions(page);

        Logs.info("Test: addOnlySubject");
        subjectsActions.addSubject(page, "Math");
        subjectsActions.addSubject(page, "Biology");
        subjectsActions.addSubject(page, "Physics");

        sumbitActions.clickSubmit(page);
    }

    @Test
    public void noAddSubject(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        SubjectsActions subjectsActions = new SubjectsActions(page);

        Logs.info("Test: noAddSubject");
        subjectsActions.addSubject(page, "papa");

        sumbitActions.clickSubmit(page);
    }

    @Test
    @Bug
    public void removeSubject(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        SubjectsActions subjectsActions = new SubjectsActions(page);

        Logs.info("Test: removeSubject");
        subjectsActions.addSubject(page, "a");
        subjectsActions.removeSubject(page);

        sumbitActions.clickSubmit(page);
    }
}
