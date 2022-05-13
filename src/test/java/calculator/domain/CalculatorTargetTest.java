package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author : choi-ys
 * @date : 2022/05/13 3:20 오후
 */
@DisplayName("Domain:CalculatorTarget")
class CalculatorTargetTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("연산 대상 객체 생성")
    public void CalculatorTargetCreateTest(
        String given,
        DelimiterType delimiterType,
        String delimiterRegex,
        String[] splitValues,
        int additionResult
    ) {
        // When
        CalculatorTarget actual = new CalculatorTarget(given);

        // Then
        assertAll(
            () -> assertThat(actual.getDelimiterType()).isEqualTo(delimiterType),
            () -> assertThat(actual.getDelimiterRegex()).as("입력된 문자열로 부터 구분자를 골라낸다.").contains(delimiterRegex),
            () -> assertThat(actual.getValues()).as("입력된 문자열로 부터 연산 대상 배열을 골라낸다.").contains(splitValues),
            () -> assertThat(actual.addition()).as("덧셈 연산 수행 결과").isEqualTo(additionResult)
        );
    }

    private static Stream CalculatorTargetCreateTest() {
        return Stream.of(
            Arguments.of("//;\n1;2;3", DelimiterType.CUSTOM, ";", new String[]{"1", "2", "3"}, 6),
            Arguments.of("1,2:3", DelimiterType.NORMAL, ",|:", new String[]{"1", "2", "3"}, 6)
        );
    }
}