package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @Test
    void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isZero();

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isZero();
    }

    @Test
    void splitAndSum_숫자하나() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isOne();
    }

    @Test
    void splitAndSum_쉼표구분자() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//!\n1!2!3", "//@\n1@2@3"})
    void splitAndSum_custom_구분자(String text) {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수가 될순없습니다.");
    }
}