package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class ValidatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    public void isNullOrEmpty_NullAndEmpty(String text) {
        assertThat(Validator.isNullOrEmpty(text)).isTrue();
    }

    @Test
    public void isNullOrEmpty_String() {
        assertThat(Validator.isNullOrEmpty("test")).isFalse();
    }

    @Test
    public void isPositiveNumber_String() {
        assertThatThrownBy(() -> Validator.isPositiveNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void isPositiveNumber_negetive() {
        assertThatThrownBy(() -> Validator.isPositiveNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
