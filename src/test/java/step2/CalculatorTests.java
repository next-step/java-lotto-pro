package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTests {

    private Calculator calculator = new Calculator();

    @ParameterizedTest
    @MethodSource("sumProvider")
    void 덧셈이_정상적으로_수행되는지_확인한다(String input, Number expected) {
        Number sum = calculator.sum(input);
        assertThat(sum).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1;2:3",
            "1.2-1",
            "1/a\n2",
            "1//a\n3",
            "1,2:3!4"
    })
    void 덧셈이_정상적으로_이루어지지_않는_경우를_테스트한다(String input) {
        assertThatThrownBy(() -> calculator.sum(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자가 아닌 값이 포함되어 있습니다.");
    }

    private static Stream<Arguments> sumProvider() {
        return Stream.of(
                Arguments.of("1,2,3,4,5", new Number(15)),
                Arguments.of("1:2:3:4:5", new Number(15)),
                Arguments.of("1,2:3,4:5", new Number(15)),
                Arguments.of("1,2:3,4:5,6", new Number(21)),
                Arguments.of("1//a\\n2", new Number(3)),
                Arguments.of("1//b\\n2", new Number(3)),
                Arguments.of("1//가\\n2", new Number(3))
        );
    }
}
