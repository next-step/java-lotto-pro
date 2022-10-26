package utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCalculatorTest {

    @DisplayName("빈문자열 또는 null 입력하는 경우")
    @Test
    void 빈문자열_확인() {
        String inputText = null;
        assertThat(StringCalculator.splitAndSum(inputText)).isEqualTo(0);

        inputText = "";
        assertThat(StringCalculator.splitAndSum(inputText)).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 입력하는 경우")
    @Test
    void 숫자_하나_입력() {
        String number = "5";
        assertThat(StringCalculator.splitAndSum(number)).isEqualTo(Integer.parseInt(number));
    }

    @DisplayName("숫자 두개 입력_구분자 콤마")
    @Test
    void 숫자_두개_입력() {
        String inputText = "1,2";
        int expected = 3;
        assertThat(StringCalculator.splitAndSum(inputText)).isEqualTo(expected);
    }

    @DisplayName("두가지 구분자 사용_콤마&콜론")
    @Test
    void 두가지_구분자() {
        String inputText = "1,2:3";
        int expected = 6;
        assertThat(StringCalculator.splitAndSum(inputText)).isEqualTo(expected);
    }

    @DisplayName("기본 구분자 사용하는 경우")
    @ParameterizedTest
    @CsvSource(value = {"1,2;3", "1,2:3;6"}, delimiter = ';')
    void 기본_구분자_테스트(String input, int expected) {
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자 사용하는 경우")
    @Test
    void 커스텀_구분자() {
        String inputText = "//;\n1;2;3";
        int expected = 6;
        assertThat(StringCalculator.splitAndSum(inputText)).isEqualTo(expected);
    }

    @DisplayName("음수 입력하는 경우 예외처리")
    @Test
    void 음수_예외처리() {
        String minusIncluded = "-10,2,3";
        assertThatThrownBy(() -> StringCalculator.splitAndSum(minusIncluded))
                .isInstanceOf(RuntimeException.class);
    }
}
