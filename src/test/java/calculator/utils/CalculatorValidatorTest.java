package calculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorValidatorTest {

    @ParameterizedTest
    @CsvSource(value = {"가","a","!"})
    @DisplayName("숫자 이외의 문자는 예외를 터트린다.")
    void notOnlyNumberExceptionTest(String input){
        assertThatIllegalArgumentException().isThrownBy(
                () -> CalculatorValidator.validateOnlyNumber(input)
        );
    }
}
