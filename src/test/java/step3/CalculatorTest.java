package step3;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    public void calculator_lotto_count() {
        Calculator calculator = new Calculator(1000);
        assertThat(calculator.getLottoCount()).isEqualTo(1);
    }
    
    @ParameterizedTest
    @CsvSource(value = {"0:0","999:0","2999:2","-1000:0"}, delimiter = ':')
    @DisplayName("변수와 예상값 입력하여 검증")
    void calculator_lotto_count_exception(Integer input, int expected) {
        Calculator calculator = new Calculator(input);
        AssertionsForClassTypes.assertThat(calculator.getLottoCount()).isEqualTo(expected);
    }
    
//    @Test
//    @DisplayName("로또번호와 당첨번호를 비교하여 당첨금 확인")
//    public void calculator_lotto_prize() {
//        Calculator calculator = new Calculator(1000);
//        assertThat(calculator.getLottoCount()).isEqualTo(1);
//    }
}
