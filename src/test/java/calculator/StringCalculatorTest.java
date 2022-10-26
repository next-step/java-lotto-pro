package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    private static int NOT_CALCULATED = 0;

    @DisplayName("문자열 계산기 생성 테스트")
    @Test
    void create() {
        //given:
        String input = "1,2,3";
        //when:
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate(input);
        //then:
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("문자열 계산기 빈 문자 입력 테스트")
    @Test
    void empty() {
        //given:
        String input = "";
        //when:
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate(input);
        //then:
        assertThat(result).isEqualTo(NOT_CALCULATED);
    }

    @DisplayName("문자열 계산기 null 입력 테스트")
    @Test
    void empty() {
        //given:
        String input = null;
        //when:
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate(input);
        //then:
        assertThat(result).isEqualTo(NOT_CALCULATED);
    }
}
