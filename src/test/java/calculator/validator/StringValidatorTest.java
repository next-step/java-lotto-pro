package calculator.validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author : choi-ys
 * @date : 2022/05/12 3:55 오후
 */
@DisplayName("Validator:String")
class StringValidatorTest {

    @ParameterizedTest
    @CsvSource(value = {"-1:false", "0:true", "a:false", "3 3:false"}, delimiterString = ":")
    @DisplayName("유효한 숫자 여부 판별")
    public void isNumberTest(String given, boolean expected) {
        // When & Then
        assertThat(StringValidator.isValidNumber(given)).isEqualTo(expected);
    }
}