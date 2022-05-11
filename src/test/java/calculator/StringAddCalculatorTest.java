package calculator;

import org.junit.jupiter.api.DisplayName;
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

}
