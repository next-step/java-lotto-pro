package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @DisplayName("돈은 0보다 커야 한다")
    @Test
    void minimum_test() {
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("돈은 0보다 커야 합니다");
    }

    @DisplayName("돈을 나눌 수 있다")
    @Test
    void divide_test() {
        double result = new Money(1_000L).divide(new Money(1_000L));
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("돈을 더할 수 있다")
    @Test
    void sum_test() {
        Money result = new Money(1_000L).sum(new Money(1_000L));
        assertThat(result).isEqualTo(new Money(2_000L));
    }

    @DisplayName("돈을 곱할 수 있다")
    @Test
    void multiply_test() {
        Money result = new Money(1_000L).multiply(2);
        assertThat(result).isEqualTo(new Money(2_000L));
    }

    @DisplayName("돈을 뺄수 있다")
    @Test
    void subtract_test() {
        Money result = new Money(2_000L).subtract(new Money(1_000L));
        assertThat(result).isEqualTo(new Money(1_000L));
    }
}
