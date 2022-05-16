package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    private static Stream<Arguments> provideIsGreaterThanEqualFixture() {
        return Stream.of(
                Arguments.of(new Money(500), true),
                Arguments.of(new Money(1000), true),
                Arguments.of(new Money(1500), false)
        );
    }

    @DisplayName("음수의 돈을 가질 수 없다.")
    @Test
    void create() {
        assertThatThrownBy(() -> new Money(-10_000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("두 값을 비교하여 크거나 같은지 확인한다.")
    @MethodSource(value = "provideIsGreaterThanEqualFixture")
    @ParameterizedTest
    void isGreaterThanEqual(Money other, boolean expected) {
        Money money = new Money(1000);
        assertThat(money.isGreaterThanEqual(other)).isEqualTo(expected);
    }

    @DisplayName("돈을 차감한다.")
    @Test
    void subtract01() {
        Money money = new Money(10_000);
        assertThat(money.subtract(new Money(1_000))).isEqualTo(new Money(9_000));
    }

    @DisplayName("돈을 차감하여도 음수의 돈을 가질 수 업다.")
    @Test
    void subtract02() {
        Money money = new Money(0);

        assertThatThrownBy(() -> money.subtract(new Money(1_000)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
