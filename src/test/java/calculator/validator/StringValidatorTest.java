package calculator.validator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

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

    @ParameterizedTest
    @MethodSource
    @DisplayName("빈값 null 여부 판별")
    public void isEmptyTest(String given, boolean expected) {
        // When & Then
        assertThat(StringValidator.isEmpty(given)).isEqualTo(expected);
    }

    public static Stream isEmptyTest() {
        return Stream.of(
            Arguments.of("", true),
            Arguments.of(null, true),
            Arguments.of(" ", true)
        );
    }
}