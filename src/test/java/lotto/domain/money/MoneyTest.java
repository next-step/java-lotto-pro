package lotto.domain.money;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    private static Stream<Arguments> purchasePrice() {
        return Stream.of(
                Arguments.of(Money.from(14000), 14),
                Arguments.of(Money.from(20000), 20),
                Arguments.of(Money.from(1123), 1)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 500})
    @DisplayName("구매금액이 로또 1장(1000원) 가격보다 작을 때 IllegalArgumentException을 발생한다.")
    void moneyException(double input) {
        Assertions.assertThatThrownBy(() -> Money.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource(value = "purchasePrice")
    @DisplayName("구매금액이 주어졌을 때 로또를 구매할 수 있는 수량을 확인한다.")
    void purchasableQuantity(Money input, int expected) {
        double result = input.purchasableQuantity();
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
