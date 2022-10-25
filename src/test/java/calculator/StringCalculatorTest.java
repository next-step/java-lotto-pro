package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    @DisplayName("빈 문자열은 0으로 반환한다.")
    void emptyStringIsZeroTest() {
        assertThat(StringCalculator.isEmpty("")).isTrue();
        assertThat(StringCalculator.plusOperation("")).isEqualTo(0);
    }

    @Test
    @DisplayName("Null 은 0으로 반환한다.")
    void nullStringIsZeroTest(){
        assertThat(StringCalculator.isNull(null)).isTrue();
        assertThat(StringCalculator.plusOperation(null)).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value={"1,2:3", "1,2,3:6", "2,4,:6", "1:1"}, delimiterString = ":")
    @DisplayName("쉼표(,)를 구분자로 취급하여 덧셈한다.")
    void plusOperationByComma(String input, int result){
        assertThat(StringCalculator.plusOperation(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2=3", "2:3:4=9", "5:2:=7"}, delimiterString = "=")
    @DisplayName("콜론(:)을 구분자로 취급하여 덧셈한다.")
    void plusOperationByColon(String input, int result){
        assertThat(StringCalculator.plusOperation(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a:1,2", "3:b", "우,", "P"})
    @DisplayName("숫자 이외의 값이 나오는 경우, 예외를 발생시킨다.")
    void exceptionByIllegalData(String input){
        assertThatThrownBy(() -> StringCalculator.plusOperation(input))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1:2:3", "5,10:-4", "10000,-10", "-9"})
    @DisplayName("음수가 나오는 경우, 예외를 발생시킨다.")
    void exceptionByMinusNumber(String input){
        assertThatThrownBy(() -> StringCalculator.plusOperation(input))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("임의의 문자를 구분자로 지정하여 덧셈합니다.")
    void customDelimiterOperation(){
        assertThat(StringCalculator.plusOperation("//;\n1;2;3")).isEqualTo(6);
    }
}

