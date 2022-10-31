package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("숫자 집합")
class NumbersTest {

    @DisplayName("숫자 집합 생성")
    @ParameterizedTest
    @MethodSource("textArray")
    void add(String[] textArray) {
        Numbers numbers = new Numbers(textArray);
        assertThat(numbers.getNumbers()).containsExactly(new Number(textArray[0]), new Number(textArray[1]), new Number(textArray[2]));
    }

    @DisplayName("숫자들의 합을 구한다.")
    @ParameterizedTest
    @MethodSource("textArray")
    void sum(String[] firstNumber) {
        Numbers numbers = new Numbers(firstNumber);
        assertThat(numbers.sum()).isEqualTo(6);
    }

    static Stream<Arguments> textArray() {
        return Stream.of(
                Arguments.of((Object) new String[]{"2", "2", "2"}),
                Arguments.of((Object) new String[]{"1", "2", "3"})
        );
    }
}
