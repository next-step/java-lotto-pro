package lotto.vo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40, 45})
    void 로또_범위_숫자(final int number) {
        assertThatCode(() -> new Number(number)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 로또_범위_밖_숫자(final int number) {
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "10", "15", "30", "35", "41", "42", "45"})
    void 문자열_로또_숫자(final String number) {
        assertThatCode(() -> new Number(number)).doesNotThrowAnyException();
    }
}