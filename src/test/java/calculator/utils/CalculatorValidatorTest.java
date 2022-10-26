package calculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorValidatorTest {

    @Test
    @DisplayName("빈 문자열인지 확인한다.")
    void checkInputIsEmpty(){
        assertThat(CalculatorValidator.isEmpty("")).isTrue();
        assertThat(CalculatorValidator.isEmpty("1")).isFalse();
        assertThat(CalculatorValidator.isEmpty("1;2;3")).isFalse();
    }

    @Test
    @DisplayName("null 문자열인지 확인한다.")
    void checkInputIsNull(){
        assertThat(CalculatorValidator.isNull(null)).isTrue();
        assertThat(CalculatorValidator.isNull("")).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"가","a","!"})
    @DisplayName("숫자 이외의 문자는 예외를 터트린다.")
    void notOnlyNumberExceptionTest(String input){
        assertThatIllegalArgumentException().isThrownBy(
                () -> CalculatorValidator.validateOnlyNumber(input)
        );
    }
}
