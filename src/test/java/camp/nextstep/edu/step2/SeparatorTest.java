package camp.nextstep.edu.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class SeparatorTest {

    @DisplayName("differentiate 함수를 통해서 구분자를 기준으로 값을 분리한다.")
    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResult")
    void differentiateTest(final String input, final String[] expectedResult) {
        String[] strNumbers = Separator.differentiate(input);
        assertThat(strNumbers).containsExactly(expectedResult);
    }

    @DisplayName("입력 값이 잘못된 경우 RuntimeException 이 발생한다.")
    @Test
    void invalidInputTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Separator.differentiate(null));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Separator.differentiate(""));
    }

    private static Stream<Arguments> provideInputAndExpectedResult() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1:2", new String[]{"1", "2"}),
                Arguments.of("1,2:3", new String[]{"1", "2", "3"}),
                Arguments.of("//;\n1;2;3", new String[]{"1", "2", "3"})
        );
    }
}
