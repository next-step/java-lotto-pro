package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 계산기 테스트")
class StringCalculatorTest {

    private static final int NOT_CALCULATED = 0;

    @DisplayName("입력 테스트 - 정상")
    @Test
    void calculate() {
        //given:
        String input = "1,2,3";
        //when:
        int result = StringCalculator.calculate(input);
        //then:
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("입력 테스트 - 빈 문자와 null")
    @NullAndEmptySource
    void calculateNullAndEmpty(String input) {
        //when:
        int result = StringCalculator.calculate(input);
        //then:
        assertThat(result).isEqualTo(NOT_CALCULATED);
    }
}
