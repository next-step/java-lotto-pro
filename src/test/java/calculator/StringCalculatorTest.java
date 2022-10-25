package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    @DisplayName("빈 문자열은 0으로 반환한다.")
    void emptyStringIsZeroTest() {
        int result = StringCalculator.isEmpty("");

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Null 은 0으로 반환한다.")
    void nullStringIsZeroTest(){
        int result = StringCalculator.isNull(null);

        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value={"1,2:3", "1,2,3:6", "2,4,:6"}, delimiterString = ":")
    @DisplayName("쉼표(,)를 구분자로 취급하여 덧셈한다.")
    void plusOperationByComma(String input, int result){
        assertThat(StringCalculator.plusOperationByComma(input)).isEqualTo(result);
    }
}

