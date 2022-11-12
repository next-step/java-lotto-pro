package play.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    @DisplayName("금액을 입력받았을 떄 맞는 개수의 로또리스트를 반환하는지 테스트")
    void calculate() {
        String input = "14000";
        Calculator counter = new Calculator();
        assertThat(counter.buyLotto(input).getLottoList()).hasSize(14);
    }
}
