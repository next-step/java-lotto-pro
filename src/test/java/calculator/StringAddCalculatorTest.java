package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다")
    @ParameterizedTest
    @MethodSource
    void nullOrEmptyInputReturnZero(String input, int expected) {
        // when
        int result = StringAddCalculator.add(input);
        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> nullOrEmptyInputReturnZero() {
        return Stream.of(
                Arguments.of(
                        null, 0
                ),
                Arguments.of(
                        "", 0
                )
        );
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    @Test
    void numberInputReturnCorrespondingNumber() {
        // when
        int result = StringAddCalculator.add("10");
        // then
        assertThat(result).isEqualTo(10);
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다")
    @Test
    void twoNumbersInputReturnSumOfNumbers() {
        // when
        int result = StringAddCalculator.add("1,2");
        // then
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다")
    @Test
    void colonsUsedAsDelimiters() {
        // when
        int result = StringAddCalculator.add("1:2,3");
        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("“//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다")
    @Test
    void customDelimiters() {
        // when
        int result = StringAddCalculator.add("//;\n1;2;7");
        // then
        assertThat(result).isEqualTo(10);
    }

}
