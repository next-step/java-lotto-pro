package stringaddcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환")
    void emptyOrNullTest(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    @DisplayName("숫자 하나를 입력할 경우 해당 숫자 반환")
    void oneNumberTest(int input) {
        int result = StringAddCalculator.splitAndSum(String.valueOf(input));
        assertThat(result).isEqualTo(input);
    }

    @ParameterizedTest
    @MethodSource("provideStringForCommaSeparate")
    @DisplayName("쉼표(,) 구분자로 구분된 숫자들의 합을 반환")
    void commaSeparatedNumbersTest(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideStringForColonSeparate")
    @DisplayName("콜론(:) 구분자로 구분된 숫자들의 합을 반환")
    void colonSeparatedNumbersTest(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideStringForCommaSeparate() {
        return Stream.of(
                Arguments.of("1,2", 3),
                Arguments.of("1,2,3", 6),
                Arguments.of("4,5", 9),
                Arguments.of("1,2,3,4,5", 15)
        );
    }

    private static Stream<Arguments> provideStringForColonSeparate() {
        return Stream.of(
                Arguments.of("1:2", 3),
                Arguments.of("1:2:3", 6),
                Arguments.of("4:5", 9),
                Arguments.of("1:2:3:4:5", 15)
        );
    }


}