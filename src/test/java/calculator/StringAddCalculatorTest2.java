package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import util.IntegerArrayConverter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("세부 함수에 대한 Testcase code")
public class StringAddCalculatorTest2 {

    @DisplayName(",를 구분자로 한 input 값을 잘 split 하는지 확인")
    @ParameterizedTest
    @CsvSource(delimiter = '^', value = {
            "1,2^1#2",
            "1,3,5^1#3#5",
    })
    public void splitForNumberTest01(String input, @ConvertWith(IntegerArrayConverter.class) Integer[] expected) {
        Integer[] numbers = StringAddCalculator.splitForNumber(input);
        assertThat(numbers)
                .hasSize(expected.length)
                .isEqualTo(expected);
    }

    @DisplayName(":를 구분자로 한 input 값을 잘 split 하는지 확인")
    @ParameterizedTest
    @CsvSource(delimiter = '^', value = {
            "1:2^1#2",
            "1:3:5^1#3#5",
    })
    public void splitForNumberTest02(String input, @ConvertWith(IntegerArrayConverter.class) Integer[] expected) {
        Integer[] numbers = StringAddCalculator.splitForNumber(input);
        assertThat(numbers)
                .hasSize(expected.length)
                .isEqualTo(expected);
    }

    @DisplayName("숫자가 아닌 값과 음수가 input에 있을 때 exception이 발생하는가?")
    @ParameterizedTest
    @CsvSource(delimiter = '^', value = {
            "1,a",
            "a,2",
            "1,-2",
            "-1,2",
    })
    public void splitForNumberTest03(String input) {
        assertThatThrownBy(() -> {
            Integer[] numbers = StringAddCalculator.splitForNumber(input);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("sum 함수가 잘 작동하는가?")
    @ParameterizedTest
    @CsvSource(delimiter = '^', value = {
            "1#2^3",
            "1#3#5^9",
    })
    public void splitForNumberTest02(@ConvertWith(IntegerArrayConverter.class) Integer[] input, int expected) {
        int sum = StringAddCalculator.sum(input);
        assertThat(sum)
                .isEqualTo(expected);
    }
}
