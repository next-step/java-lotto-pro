package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {

    @Test
    @DisplayName("Number 합 연산 테스트")
    public void number_add() {
        Number number = new Number("1");
        number.add(new Number("2"));
        assertThat(number.getNumber()).isEqualTo(3);
    }
}
