package annotations;

import org.junit.jupiter.api.Tag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Tag("pruebaExitosa")
@Retention(value = RetentionPolicy.RUNTIME)
public @interface PruebaExitosa {
}
