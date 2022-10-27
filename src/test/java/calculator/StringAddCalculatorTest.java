package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @DisplayName("구분자로 나눠진 문자열 리스트 숫자로 변환하여 합")
    @MethodSource("inputStrings")
    void split_list_sum(String testCase, int expectSum) {
        assertThat(StringAddCalculator.splitAndSum(testCase)).isEqualTo(expectSum);
    }

    @ParameterizedTest
    @DisplayName("구분자로 나눠진 문자열 리스트 중 숫자가 아닌 문자가 포함되어 RuntimeException발생")
    @ValueSource(strings = {"1,#,3", "2:!:4", "3:bad,5", "//_\n4_5_ssss"})
    void not_number_runtime_exception(String testCase) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(testCase))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(CalculatorStatus.INVALID_VALUE.getMessage());
    }

    @ParameterizedTest
    @DisplayName("구분자로 나눠진 문자열 리스트 중 음수의 숫자가 포함되어 RuntimeException발생")
    @ValueSource(strings = {"1,-1,3", "2:-4:4", "3:-6,5", "//_\n4_5_-7"})
    void negative_number_runtime_exception(String testCase) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(testCase))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(CalculatorStatus.NEGATIVE_NUMBER.getMessage());
    }

    private static Stream<Arguments> inputStrings() {
        return Stream.of(
                Arguments.of("1,2,3", 6),
                Arguments.of("2:3:4", 9),
                Arguments.of("3:4,5", 12),
                Arguments.of("//_\n4_5_6", 15)
        );
    }
}
