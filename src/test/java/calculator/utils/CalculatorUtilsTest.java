package calculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.utils.CalculatorUtils.split;
import static org.assertj.core.api.Assertions.assertThat;

class CalculatorUtilsTest {

    @ParameterizedTest
    @DisplayName("기본 또는 커스텀 구분자을 기준으로 입력값을 쪼갠다.")
    @ValueSource(strings = {"1,2,3", "1,2:3", "//;\n1;2;3"})
    void split_기본_또는_커스텀_구분자(String input) {
        assertThat(split(input))
                .isExactlyInstanceOf(String[].class)
                .containsExactly("1", "2", "3");
    }
}