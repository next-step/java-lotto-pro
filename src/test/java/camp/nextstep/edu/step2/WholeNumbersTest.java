package camp.nextstep.edu.step2;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class WholeNumbersTest {

    @DisplayName("sum 메소드를 통해서 더한 결과 값을 알수 있다.")
    @ParameterizedTest
    @MethodSource("provideStrNumberArrayAndExpectedSumResult")
    void sumTest(final WholeNumber[] numbers, final int expectedSumResult) {
        AssertionsForClassTypes.assertThat(new WholeNumbers(numbers).sum()).isEqualTo(expectedSumResult);
    }

    private static Stream<Arguments> provideStrNumberArrayAndExpectedSumResult() {
        return Stream.of(
                Arguments.of(new WholeNumber[] {new WholeNumber("1")}, 1),
                Arguments.of(new WholeNumber[] {
                        new WholeNumber("1"),
                        new WholeNumber("2"),
                        new WholeNumber("3")
                }, 6)
        );
    }
}
