package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    private final StringAddCalculator stringAddCalculator = new StringAddCalculator();
    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String text) {
        int result = stringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() {
        int result = stringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() {
        int result = stringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = stringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() {
        int result = stringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void splitAndSum_일반문자() {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("a,b,c"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void splitAndSum_특수문자() {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("*,/,-,+"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}