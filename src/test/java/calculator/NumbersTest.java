package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {
    @ParameterizedTest(name = "{index}. {0} 테스트")
    @MethodSource("provideArrayListForNumbers")
    void calculateSumTest(String testTitle, List<Number> numbersInput, int expect) {
        // given
        Numbers numbers = new Numbers(numbersInput);
        // when
        int result = numbers.getSum();
        // then
        assertThat(result).isEqualTo(expect);
    }

    private static Stream<Arguments> provideArrayListForNumbers() {
        return Stream.of(
                Arguments.of("숫자 하나 입력", Arrays.asList(new Number("1")), 1),
                Arguments.of("숫자 여러개 입력", Arrays.asList(new Number("1"), new Number("2")), 3)
        );
    }

    @DisplayName("잘못된 숫자 입력 예외")
    @Test
    void inputWrongNumber() {
        assertThatThrownBy(() -> {
            Numbers numbers = new Numbers(Arrays.asList(new Number("a"), new Number("2")));
            int result = numbers.getSum();
        }).isInstanceOf(NumberFormatException.class)
        .hasMessageContaining("입력한 숫자를 확인해 주세요.");
    }

    @DisplayName("음수 입력 예외")
    @Test
    void inputNegativeNumber() {
        assertThatThrownBy(() -> {
            Numbers numbers = new Numbers(Arrays.asList(new Number("-1"), new Number("2")));
            int result = numbers.getSum();
        }).isInstanceOf(NegativeNumberException.class)
                .hasMessageContaining("입력된 숫자가 0 미만입니다.");
    }
}
