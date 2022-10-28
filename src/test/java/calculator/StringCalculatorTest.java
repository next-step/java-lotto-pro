package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    private static final int NOT_CALCULATED = 0;

    @DisplayName("문자열 계산기 입력 테스트 - 정상")
    @Test
    void calculate() {
        //given:
        String input = "1,2,3";
        //when:
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate(input);
        //then:
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("문자열 계산기 입력 테스트 - 빈 문자와 null")
    @NullAndEmptySource
    void calculateNullAndEmpty(String input) {
        //when:
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate(input);
        //then:
        assertThat(result).isEqualTo(NOT_CALCULATED);
    }
}
