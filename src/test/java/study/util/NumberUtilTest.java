package study.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberUtilTest {

    @Test
    void convertToPositiveIntNotContainsZero_0이_입력되면_IllegalArgumentException_발생() {
        assertThatThrownBy(() -> {
            NumberUtil.convertToPositiveIntNotContainsZero("0");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] The given string cannot contain zero.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3"})
    void convertToPositiveInt_음수이면_IllegalArgumentException_발생(String str) {
        assertThatThrownBy(() -> {
            NumberUtil.convertToPositiveInt(str);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] The given string cannot contain negative numbers.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "문자"})
    void convertToPositiveInt_숫자로_변환할_수_없으면_IllegalArgumentException_발생(String str) {
        assertThatThrownBy(() -> {
            NumberUtil.convertToPositiveInt(str);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] The given string contains characters that cannot be converted to numbers.");
    }

    @DisplayName("문자열을 숫자로 변환하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    void convertStrToInt(String str, int expected) {
        assertThat(NumberUtil.convertToPositiveInt(str)).isEqualTo(expected);
    }

    @Test
    void divideAndCeil_0이_입력되면_ArithmeticException_발생() {
        assertThatThrownBy(() -> {
            NumberUtil.divideAndCeil(0, 10);
        }).isInstanceOf(ArithmeticException.class)
                .hasMessage("[ERROR] It cannot be divided by zero.");
    }

    @Test
    @DisplayName("두 숫자를 나누어 올림하는 테스트")
    void divideAndCeil() {
        assertEquals(2L, NumberUtil.divideAndCeil(10, 5));
    }
}
