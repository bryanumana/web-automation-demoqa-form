package tests;

import actions.SelectPictureActions;
import actions.SumbitActions;
import annotations.Bug;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import utilities.BaseTests;
import utilities.Logs;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SelectPictureTest extends BaseTests {
    Path photoPathValidExtension = Paths.get("src/test/resources/files/kenny.jpg");
    Path photoPathInvalidExtension = Paths.get("src/test/resources/files/data_suites.csv");

    @Test
    public void uploadValidPicture(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        SelectPictureActions selectPictureActions = new SelectPictureActions(page);

        Logs.info("Test: uploadPicture");

        selectPictureActions.selectPicture(page, photoPathValidExtension);
        sumbitActions.clickSubmit(page);
    }

    @Test
    @Bug
    public void uploadInvalidExtend(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        SelectPictureActions selectPictureActions = new SelectPictureActions(page);

        Logs.info("Test: uploadInvalidExtendPicture");

        selectPictureActions.selectPicture(page, photoPathInvalidExtension);
        sumbitActions.clickSubmit(page);
    }

    @Test
    public void noUploadPicture(Page page) {
        SumbitActions sumbitActions = new SumbitActions(page);
        SelectPictureActions selectPictureActions = new SelectPictureActions(page);

        Logs.info("Test: uploadPicture");

        sumbitActions.clickSubmit(page);

        selectPictureActions.selectPictureFailed();
    }
}
