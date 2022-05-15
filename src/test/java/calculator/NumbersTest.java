package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {
    @ParameterizedTest
    @CsvSource(value = {"1:1", "1,2:3", "1,2,3:6"}, delimiter = ':')
    @DisplayName("숫자 주어졌을 때 합계 맞는지 확인")
    public void numbers_sum(String input, int expected) {
        Numbers numbers = new Numbers(input);
        assertThat(numbers.sum()).isEqualTo(expected);
    }
}
