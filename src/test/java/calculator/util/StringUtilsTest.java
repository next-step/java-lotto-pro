package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
