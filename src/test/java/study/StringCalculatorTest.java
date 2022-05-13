package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    @Test
    @DisplayName("공백 또는 null 문자열 계산")
    void split_null_or_empty_test() {
        assertEquals(0, StringCalculator.splitAndSum(null));
        assertEquals(0, StringCalculator.splitAndSum(""));
    }

    @Test
    @DisplayName("숫자 하나 문자열 계산")
    void split_one_test() {
        assertEquals(2, StringCalculator.splitAndSum("2"));

    }

    @Test
    @DisplayName("쉼표 구분자 계산")
    void split_comma_delimiter_test() {
        assertEquals(9, StringCalculator.splitAndSum("1,3,5"));
    }

    @Test
    @DisplayName("콜론 구분자 계산")
    void split_colon_delimiter_test() {
        assertEquals(9, StringCalculator.splitAndSum("1:3:5"));
    }

    @Test
    @DisplayName("혼합 구분자 계산")
    void split_mix_delimiter_test() {
        assertEquals(9, StringCalculator.splitAndSum("1,3:5"));
    }

    @Test
    @DisplayName("커스텀 구분자 계산")
    void split_custom_delimiter_test() {
        assertEquals(9, StringCalculator.splitAndSum("//;\n1;3;5"));
    }

    @Test
    @DisplayName("음수 값 오류 확인")
    void exception_negative_number_test() {
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.splitAndSum("1,3,-5"));
    }
}
