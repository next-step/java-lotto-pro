package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("문자열을 입력받을 때, 빈 문자열인 경우 0을 리턴한다.")
    void input_test(String inputText) {
        int result = stringAddCalculator.sum(inputText);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나 입력 테스트를 해본다.")
    void one_number_test() {
        int result = stringAddCalculator.sum("2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("쉼표로 구분할 경우 숫자의 합을 반환한다.")
    void splitAndSum_comma() {
        int result = stringAddCalculator.sum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "1:2,3=6"}, delimiter = '=')
    @DisplayName("쉼표와 콜론으로 split한 숫자를 합해서 반환하는지 확인한다.")
    void split_colon_comma_test(String input, int expected) {
        int result = stringAddCalculator.sum(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("쉼표와 콜론으로 split한 숫자를 합해서 반환하는지 확인한다.")
    void custom_separator_test() {
        int result = stringAddCalculator.sum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }
}