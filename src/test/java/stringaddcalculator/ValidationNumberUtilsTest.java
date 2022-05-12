package stringaddcalculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ValidationNumberUtilsTest {

    @Test
    void 입력받은_값에_음수를_전달하는_경우_runtimeException() {
        ValidateStringUtils.validatePositiveNumber(Arrays.asList(1, 2, 0));
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> ValidateStringUtils.validatePositiveNumber(Arrays.asList(1, -2, 0)));
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> ValidateStringUtils.validatePositiveNumber(Arrays.asList(-1, 2, 0)));
    }
}
