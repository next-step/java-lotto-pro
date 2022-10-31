package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("숫자 집합")
class NumbersTest {

    @DisplayName("숫자 추가")
    @ParameterizedTest
    @CsvSource({"1, 7", "2, 8"})
    void name(String firstNumber, String secondNumber) {
        Numbers numbers = new Numbers();
        numbers.add(new Number(firstNumber));
        numbers.add(new Number(secondNumber));
        assertThat(numbers.getNumbers()).containsExactly(new Number(firstNumber), new Number(secondNumber));
    }
}
