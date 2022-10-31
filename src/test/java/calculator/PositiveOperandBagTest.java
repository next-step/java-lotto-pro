package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("양의 정수인 피연산자 목록 테스트")
class PositiveOperandBagTest {

    @DisplayName("sum 메서드 테스트")
    @Test
    void sum_operandWords_success() {
        //given:
        List<String> input = Arrays.asList("1", "2", "3");
        //when, then:
        assertThat(PositiveOperandBag.sum(input)).isEqualTo(6);
    }
}
