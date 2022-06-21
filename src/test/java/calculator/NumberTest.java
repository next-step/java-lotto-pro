package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {
    @ParameterizedTest
    @ValueSource(ints = {112, 119, 0, 1234567890})
    void inputPositiveOrZero(final int number) {
        assertThatCode(() -> new Number(number)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void inputNegative(final int number) {
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc1", "가나다라"})
    void inputException(final String number) {
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(NumberFormatException.class);
    }
}