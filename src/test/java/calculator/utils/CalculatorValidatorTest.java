package calculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorValidatorTest {

    @Test
    @DisplayName("빈 문자열인지 확인한다.")
    void checkInputIsEmpty(){
        assertAll(
                () -> assertTrue(CalculatorValidator.isEmpty(""), "빈 문자열 검증 실패"),
                () -> assertFalse(CalculatorValidator.isEmpty("1"), "빈 문자열 아닌데 검증 실패")
        );
    }

    @Test
    @DisplayName("null 문자열인지 확인한다.")
    void checkInputIsNull(){
        assertAll(
                () -> assertTrue(CalculatorValidator.isNull(null), "null 문자열 검증 실패"),
                () -> assertFalse(CalculatorValidator.isNull(""), "빈 문자열은 null 이 아닌데 null 로 검증함")
        );
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
