package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringAddCalculatorTest {

    @Test
    @DisplayName("입력값이 null이면 결과는 0이다")
    void splitAndSum_null() {
        // given & when
        int result = StringAddCalculator.splitAndSum(null);

        // then
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("입력값이 빈문자이면 결과는 0이다")
    void splitAndSum_빈문자() {
        // given & when
        int result = StringAddCalculator.splitAndSum("");

        // then
        assertThat(result).isZero();
    }

    @Test
    void splitAndSum_숫자하나() {
        // given & when
        int result = StringAddCalculator.splitAndSum("1");

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void splitAndSum_쉼표구분자() {
        // given & when
        int result = StringAddCalculator.splitAndSum("1,2");

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() {
        // given & when
        int result = StringAddCalculator.splitAndSum("1,2:3");

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_custom_구분자() {
        // given & when
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_negative() {
        // given & when & then
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
