package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringCalculatorTest {
    @Test
    @DisplayName("빈 문자열 혹은 null일 경우 0이 응답된다.")
    void checkEmptyOrNull() {
        StringCalculator stringCalculator = new StringCalculator();

        assertAll(
                () -> assertThat(stringCalculator.splitAndSum("")).isEqualTo(0),
                () -> assertThat(stringCalculator.splitAndSum(null)).isEqualTo(0)
        );
    }


    @Test
    @DisplayName("음수 혹은 숫자가 아닐 경우 IllegalArgumentException 이 발생한다.")
    void checkInvalidInput() {
        StringCalculator stringCalculator = new StringCalculator();

        assertAll(
                () -> assertThatThrownBy(() -> {
                    stringCalculator.splitAndSum("-3");
                }).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> {
                    stringCalculator.splitAndSum("@");
                }).isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    @DisplayName("주어진 문자열을 쪼개어 덧셈한다.")
    void checkSumNumbers() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThat(stringCalculator.splitAndSum("1")).isEqualTo(1);
        assertThat(stringCalculator.splitAndSum("1,2,3")).isEqualTo(6);
        assertThat(stringCalculator.splitAndSum("1:2")).isEqualTo(3);
        assertThat(stringCalculator.splitAndSum("1:2,3:4")).isEqualTo(10);
        assertThat(stringCalculator.splitAndSum("//-\n1-2-3")).isEqualTo(6);
        assertThat(stringCalculator.splitAndSum("//#\n1#2#3")).isEqualTo(6);
    }
}
