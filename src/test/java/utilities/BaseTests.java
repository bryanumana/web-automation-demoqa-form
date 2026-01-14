package utilities;

import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.BeforeEach;

@UsePlaywright(CustomOptions.class)
public class BaseTests {
    @BeforeEach
    public void beforeEach() {
        Logs.info("Iniciando...");
    }
}
