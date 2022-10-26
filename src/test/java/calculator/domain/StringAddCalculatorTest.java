package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import calculator.constant.ErrorCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorTest {

    @Test
    void split대상_문자가_null_또는_비어있음() {
        assertAll(
                () -> assertThat(StringAddCalculator.splitAndSum(null)).isZero(),
                () -> assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    void split대상_숫자_내_구분자_없음(String text, int expectedSum) {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(expectedSum);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "2,3:5", "1,2,3:6", "1,2,34:37"}, delimiter = ':')
    void split대상_숫자_내_콤마_구분자(String text, int expectedSum) {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(expectedSum);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2-3", "2:3-5", "1:2:3-6", "1:2:34-37"}, delimiter = '-')
    void split대상_숫자_내_콜론_구분자(String text, int expectedSum) {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(expectedSum);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3-6", "2:3,1-6", "1:23,3-27", "1,2:34,4-41"}, delimiter = '-')
    void split대상_숫자_내_콜론_콤마_구분자(String text, int expectedSum) {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(expectedSum);
    }

    @Test
    void split대상_숫자_내_음수_존재시_예외_발생() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2:3")).isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorCode.음의_정수가_입력되면_안됨.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"가,2:3", "가가:2:3", "2:3,나"})
    void split대상_숫자가_아닌_값_존재시_예외_발생(String text) {
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> StringAddCalculator.splitAndSum(text))
                .withMessageContaining("정수가 아닌 값이 입력되었습니다.");
    }

    @Test
    void split_대상_숫자의_합이_int_범위를_넘는_경우() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("2147483647,1")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.덧셈_결과_INT_양의_범위_넘김.getErrorMessage());
    }

    @Test
    void split대상_숫자_내_커스텀_구분자_존재() {
        assertAll(
                () -> assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6),
                () -> assertThat(StringAddCalculator.splitAndSum("//-\n1-23-56")).isEqualTo(80)
        );
    }
}
