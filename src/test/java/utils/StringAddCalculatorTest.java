package utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorTest {

    // 기능 요구사항1 - 쉼표, 콜른의 기본 구분자로 split
    @Test
    void splitAndSum_null_또는_빈문자(){
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void splitAndSum_숫자하나(){
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


    // 기능 요구사항2 - 커스텀 구분자를 지정하여 split
    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }


    // 기능 요구사항3 - 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 발생 테스트
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "a,2,3"})
    public void splitAndSum_negative(String strings) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(strings))
                .isInstanceOf(RuntimeException.class);
    }


}
