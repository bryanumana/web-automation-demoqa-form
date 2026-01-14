package utilities;

import com.microsoft.playwright.Page;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class AllureUtils {

    @Step("{stepName}")
    public static void stepWithScreenshot(Page page, String stepName) {
        attachScreenshot(page);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] attachScreenshot(Page page) {
        return page.screenshot();
    }
}
