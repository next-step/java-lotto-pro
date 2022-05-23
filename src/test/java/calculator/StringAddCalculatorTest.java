package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
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
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("숫자가 아닌 문자가 포함되어 있을 경우 Exception 확인")
    @Test
    public void splitAndSum_noneNumber() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1,B,3"))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("Custom Delimiter 정규식을 제대로 따르지 못한 문자열일 경우 Exception 확인")
    @Test
    public void splitAndSum_wrongCustomDelimiterFormat() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("/;\n1;2;3"))
                .isInstanceOf(NumberFormatException.class);
    }
}
