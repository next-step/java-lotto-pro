package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @DisplayName("splitAndSum_null_또는_빈문자_0_반환")
    @ParameterizedTest
    @CsvSource(value = {"NIL:0", ":0"}, nullValues = "NIL", delimiter = ':')
    public void splitAndSum_01(String text, int expectedData) {
        Number result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(new Number(expectedData));
    }

    @DisplayName("splitAndSum_숫자만_있으면_숫자반환")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "100:100"}, delimiter = ':')
    public void splitAndSum_02(String text, int expectedData) {
        Number result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(new Number(expectedData));
    }

    @DisplayName("splitAndSum_쉼표구분자")
    @Test
    public void splitAndSum_03() {
        Number result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(new Number(3));
    }

    @DisplayName("splitAndSum_쉼표_또는_콜론_구분자")
    @Test
    public void splitAndSum_04() {
        Number result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(new Number(6));
    }

    @DisplayName("splitAndSum_custom_구분자")
    @Test
    public void splitAndSum_05() {
        Number result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(new Number(6));
    }

    @DisplayName("splitAndSum_custom_구분자_없을경우_에러")
    @Test
    public void splitAndSum_06() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//\n1;2;3"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("splitAndSum_음수_포함일때_에러")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1,-2,3", "1,2,-3"})
    public void splitAndSum_07(String text) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(text))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("splitAndSum_파싱_후_숫자_아닐때_에러")
    @ParameterizedTest
    @ValueSource(strings = {"-a,2,3", "1,a,3", "1,2,a"})
    public void splitAndSum_08(String text) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(text))
                .isInstanceOf(RuntimeException.class);
    }
}
