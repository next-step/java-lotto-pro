import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @CsvSource(value = {"1,2,3;6", "1,2;3"}, delimiter = ';')
    public void splitAndSum_쉼표구분자(String text, int sum) throws Exception {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(sum);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3;6", "1:2;3", "1:2:3;6"}, delimiter = ';')
    public void splitAndSum_쉼표_또는_콜론_구분자(String text, int sum) throws Exception {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(sum);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//a\n1a2a3"})
    public void splitAndSum_custom_구분자(String text) throws Exception {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1,-2"})
    public void splitAndSum_negative(String text) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(text))
            .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-", "a", "1,2,c", "2a,3:5"})
    public void splitAndSum_숫자_이외의_값(String text) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(text))
            .isInstanceOf(RuntimeException.class);
    }
}
