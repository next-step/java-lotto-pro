package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static stringcalculator.constants.ErrorMessageConstants.NON_POSITIVE_INTEGER_INPUT_ERROR;

import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(NON_POSITIVE_INTEGER_INPUT_ERROR);
    }

    @Test
    void splitAndSum_두자리_이상_숫자() {
        int result = StringAddCalculator.splitAndSum("11,22,33");
        assertThat(result).isEqualTo(66);
    }

    @Test
    void checkIntegerType() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("a,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NON_POSITIVE_INTEGER_INPUT_ERROR);
    }
}
