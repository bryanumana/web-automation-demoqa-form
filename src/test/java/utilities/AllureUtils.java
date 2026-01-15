package utilities;

import com.microsoft.playwright.Page;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class AllureUtils {

    @Step("{stepName}")
    public static void infoStepWithScreenshot(Page page, String stepName) {
        Logs.info(stepName);
        attachScreenshot(page);
    }

    @Step("{stepName}")
    public static void errorStepWithScreenshot(Page page, String stepName) {
        Logs.error(stepName);
        attachScreenshot(page);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] attachScreenshot(Page page) {
        return page.screenshot();
    }
}
