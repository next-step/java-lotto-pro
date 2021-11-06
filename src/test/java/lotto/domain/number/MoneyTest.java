package lotto.domain.number;

import lotto.exception.OutOfBoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @DisplayName("정적팩토리 메서드를 이용하여 메서드를 생성하면 객체가 만들어진다.")
    @Test
    void create() {
        assertThat(Money.from(1000)).isInstanceOf(Money.class);
    }

    @DisplayName("돈의 수치가 음수이면 예외를 던진다.")
    @Test
    void exceptionTest() {
        assertThatThrownBy(() -> Money.from(-1000)).isInstanceOf(OutOfBoundException.class);
    }

    @DisplayName("돈을 수치를 곱하는 메서드를 이용하면, 곱한 값을 반환한다.")
    @Test
    void multiplyTest() {
        assertThat(Money.from(1000).multiply(15)).isEqualTo(15000L);
    }
}
