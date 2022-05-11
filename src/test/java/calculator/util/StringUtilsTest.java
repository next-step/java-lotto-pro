package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringUtilsTest {

    @Test
    @DisplayName("문자열이 공백시 true를 반환한다.")
    void isEmpty() {
        assertThat(StringUtils.isEmptyString("")).isTrue();
    }

    @Test
    @DisplayName("문자열이 null일시 true를 반환한다.")
    void isNull() {
        assertThat(StringUtils.isEmptyString(null)).isTrue();
    }

    @Test
    @DisplayName("문자열이 채워저 있을시 false를 반환한다.")
    void isNotEmpty() {
        assertThat(StringUtils.isEmptyString("a")).isFalse();
    }

    @Test
    @DisplayName("숫자와 구분자로 이루어진 문자열을 숫자 배열로 반환 한다.")
    void splitToInt() {
        assertAll(() -> {
            assertThat(StringUtils.splitToInt("1,3,4", ",")).containsExactly(1,3,4);
            assertThat(StringUtils.splitToInt("1;3;4", ";")).containsExactly(1,3,4);
            assertThat(StringUtils.splitToInt("1;3,4", ";|,")).containsExactly(1,3,4);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"a,3,4=,"
            ,"a;,3,4=,"
            ,"a3,3,4=,"
            ,"a3,3,4=:"}, delimiterString = "=")
    @DisplayName("숫자로 이루어져 있지 않은 문자열인 경우 RuntimeException 발생한다.")
    void splitToIntError(String word, String separator) {
        assertThatThrownBy(() -> StringUtils.splitToInt(word, separator))
                .isInstanceOf(RuntimeException.class);

    }
}
