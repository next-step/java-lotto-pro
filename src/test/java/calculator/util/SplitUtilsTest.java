package calculator.util;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SplitUtilsTest {

    @Test
    @DisplayName("숫자와 구분자로 이루어진 문자열을 숫자 배열로 반환 한다.")
    void splitToInt() {
        assertAll(() -> {
            assertThat(SplitUtils.splitToInt("1,3,4", ",")).containsExactly(1,3,4);
            assertThat(SplitUtils.splitToInt("1;3;4", ";")).containsExactly(1,3,4);
            assertThat(SplitUtils.splitToInt("1;3,4", ";|,")).containsExactly(1,3,4);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"a,3,4=,"
            ,"a;,3,4=,"
            ,"a3,3,4=,"
            ,"a3,3,4=:"}, delimiterString = "=")
    @DisplayName("숫자로 이루어져 있지 않은 문자열인 경우 RuntimeException 발생한다.")
    void splitToIntError(String word, String separator) {
        assertThatThrownBy(() -> SplitUtils.splitToInt(word, separator))
                .isInstanceOf(RuntimeException.class);

    }

}