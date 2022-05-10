package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringAddCalculatorTest {

    @Test
    @DisplayName("문자열 계산기에 전달된 값이 null인 경우 0이 반환된다.")
    void emptyCase01(){
        // given
        String text = null;

        // when
        Integer sum = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(sum).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열 계산기에 전달된 값이 공백인 경우 0이 반환된다.")
    void emptyCase02(){
        // given
        String text = "";

        // when
        Integer sum = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(sum).isEqualTo(0);
    }
}