package string_add_calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"a:false","-:false","0:true","9:true"}, delimiter = ':')
    void isCharIntValue_문자_숫자형식_유효성_테스트(char input, boolean expected) {
        assertThat(StringAddCalculator.isCharIntValue(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aa","-1","-10"})
    void toInt_문자열_숫자형식_유효성_테스트(String input) {
        assertThatThrownBy(() -> StringAddCalculator.toInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    public void splitAndSum_null_또는_빈문자_테스트() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나_테스트() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자_테스트() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_음수포함_테스트() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void splitAndSum_문자형식_테스트() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("aaa:bbb"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {":",":,:"})
    public void splitAndSum_구분자만있는경우_테스트(String input) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void splitAndSum_custom구분자_테스트() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_custom구분자_기본구분자_섞인경우_테스트() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3,4:5");
        assertThat(result).isEqualTo(15);
    }


}
