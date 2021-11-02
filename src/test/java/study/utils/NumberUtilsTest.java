package study.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberUtilsTest {

    @DisplayName("isNegative 테스트")
    @ParameterizedTest(name = "{displayName}{index} -> str: {0}, expected: {1}")
    @CsvSource(value = {"-1:true", "0:false", "1:false"}, delimiter = ':')
    void isNegative(int number, boolean expected) {
        // when
        boolean result = NumberUtils.isNegative(number);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
