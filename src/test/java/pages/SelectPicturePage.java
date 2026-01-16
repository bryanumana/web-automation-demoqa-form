package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SelectPicturePage {
    private final Page page;
    private final Locator btnFile;


    public SelectPicturePage(Page page) {
        this.page = page;
        this.btnFile = page.locator("input[type='file']#uploadPicture");
    }

    public Locator fileButton() {
        return btnFile;
    }
}
