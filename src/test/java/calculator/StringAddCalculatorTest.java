package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @DisplayName("빈 문자 or null 입력 테스트")
    @Test
    void splitAndSumNullOrEmptyText() {
        // given
        String text = "";
        // when
        int result = StringAddCalculator.splitAndSum(text);
        // then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("커스텀 구분자 없이 입력 후 합계 확인")
    @Test
    void splitAndSumNullWithoutCustomDelimiter() {
        // given
        String text = "1,2,3";
        // when
        int result = StringAddCalculator.splitAndSum(text);
        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자가 있는 입력 후 합계 확인")
    @Test
    void splitAndSumNullWithCustomDelimiter() {
        // given
        String text = "//b\n1b2b3";
        // when
        int result = StringAddCalculator.splitAndSum(text);
        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("값 하나 합계 테스트")
    @Test
    void splitAndSumNullSingle() {
        // given
        String text = "//b\n1";
        // when
        int result = StringAddCalculator.splitAndSum(text);
        // then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("값 여러개 합계 테스트")
    @Test
    void splitAndSumNullMultiple() {
        // given
        String text = "//b\n1,2b3";
        // when
        int result = StringAddCalculator.splitAndSum(text);
        // then
        assertThat(result).isEqualTo(6);
    }
}
