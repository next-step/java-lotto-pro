package study.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3"})
    void convertStrToInt_음수이면_RuntimeException_발생(String str) {
        assertThatThrownBy(() -> {
            NumberUtil.convertToPositiveInt(str);
        }).isInstanceOf(RuntimeException.class)
                .hasMessage("[ERROR] The given string cannot contain negative numbers.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "문자"})
    void convertStrToInt_숫자로_변환할_수_없으면_RuntimeException_발생(String str) {
        assertThatThrownBy(() -> {
            NumberUtil.convertToPositiveInt(str);
        }).isInstanceOf(RuntimeException.class)
                .hasMessage("[ERROR] The given string contains characters that cannot be converted to numbers.");
    }

    @DisplayName("문자열을 숫자로 변환하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    void convertStrToInt(String str, int expected) {
        assertThat(NumberUtil.convertToPositiveInt(str)).isEqualTo(expected);
    }
}
