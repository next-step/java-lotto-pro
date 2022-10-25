package utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorTest {

    // 기능 요구사항1 - 쉼표, 콜른의 기본 구분자로 split
    @DisplayName("null 또는 빈 문자열을 입력 할 경우 0을 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void splitAndSum_null_또는_빈문자(String input){
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void splitAndSum_숫자하나(){
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }


    // 기능 요구사항2 - 커스텀 구분자를 지정하여 split
    @DisplayName("//와 \n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }


    // 기능 요구사항3 - 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 발생 테스트
    @DisplayName("숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "a,2,3"})
    public void splitAndSum_negative(String strings) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(strings))
                .isInstanceOf(RuntimeException.class);
    }

}
