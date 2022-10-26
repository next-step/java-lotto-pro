package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {
    private StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = stringAddCalculator.sum(null);
        assertThat(result).isEqualTo(0);

        result = stringAddCalculator.sum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() {
        int result = stringAddCalculator.sum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() {
        int result = stringAddCalculator.sum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = stringAddCalculator.sum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() {
        int result = stringAddCalculator.sum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> stringAddCalculator.sum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}