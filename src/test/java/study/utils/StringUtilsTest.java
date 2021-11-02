package study.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @DisplayName("isBlank 테스트")
    @ParameterizedTest(name = "{displayName}{index}")
    @CsvSource(value = {"null:true", "'':true", "' ':true"}, nullValues = {"null"}, delimiter = ':')
    void isBlank(String str, boolean expected) {
        // when
        boolean result = StringUtils.isBlank(str);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("isEmpty 테스트")
    @ParameterizedTest(name = "{displayName}{index}")
    @CsvSource(value = {"null:true", "'':true", "' ':false"}, nullValues = {"null"}, delimiter = ':')
    void isEmpty(String str, boolean expected) {
        // when
        boolean result = StringUtils.isEmpty(str);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("isNull 테스트")
    @ParameterizedTest(name = "{displayName}{index}")
    @CsvSource(value = {"null:true", "'':false", "' ':false"}, nullValues = {"null"}, delimiter = ':')
    void isNull(String str, boolean expected) {
        // when
        boolean result = StringUtils.isNull(str);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("isNumber 테스트")
    @ParameterizedTest(name = "{displayName} -> str: {0}, expected: {1}")
    @CsvSource(value = {"-1:true", "0:true", "1:true", "a:false", "가:false"}, delimiter = ':')
    void isNumber(String str, boolean expected) {
        // when
        boolean result = StringUtils.isNumber(str);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
