package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @ParameterizedTest(name = "{index}. {0} 테스트")
    @MethodSource("provideStringsForUnitTest")
    void calculateSumTest(String testTitle, String text, int expect) {
        // when
        int result = StringAddCalculator.splitAndSum(text);
        // then
        assertThat(result).isEqualTo(expect);
    }

    private static Stream<Arguments> provideStringsForUnitTest() {
        return Stream.of(
                Arguments.of("null 입력", null, 0),
                Arguments.of("빈문자 입력", "", 0),
                Arguments.of("기본 구분자 합계", "1,2,3", 6),
                Arguments.of("커스텀 구분자 합계", "//b\n1b2b3", 6),
                Arguments.of("단일 숫자 합계", "//b\n1", 1),
                Arguments.of("여러개 숫자, 여러 구분자 합계(커스텀 구분자)", "//b\n1,2b3", 6),
                Arguments.of("여러개 숫자, 여러 구분자 합계", "1,2", 3),
                Arguments.of("숫자 여러개 테스트 (구분자 개수 2개)", "1,2:3", 6),
                Arguments.of("숫자 여러개 테스트 (커스텀 구분자)", "//;\n1;2;3", 6)
        );
    }

    @ParameterizedTest(name = "{index}. {0} 예외 테스트")
    @CsvSource(value = {"-1,2,3 4", "-1,-2,-3 -6", "-4,-2,-3 -9", "a,b:c 1"}, delimiterString = " ")
    void exceptionTest(String text, int expect) {
        assertThatThrownBy(() -> {
            // when
            int result = StringAddCalculator.splitAndSum(text);
        }).isInstanceOf(RuntimeException.class);
    }
}
