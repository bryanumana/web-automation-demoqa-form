package utilities;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;

import java.util.List;

public class CustomOptions implements OptionsFactory {
    @Override
    public Options getOptions() {
        return new Options()
                .setLaunchOptions(createLaunchOptions())
                .setContextOptions(createNewContextOptions())
                .setHeadless(false)
                .setBrowserName("chromium")
                .setChannel("chrome");
    }

    private BrowserType.LaunchOptions createLaunchOptions() {
        final var arguments = List.of("--start-maximized");
        return new BrowserType
                .LaunchOptions()
                //.setSlowMo(1500)
                .setArgs(arguments);
    }

    private Browser.NewContextOptions createNewContextOptions() {
        return new Browser.NewContextOptions().setViewportSize(null);
    }
}
