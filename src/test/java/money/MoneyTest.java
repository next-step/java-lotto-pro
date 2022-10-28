package money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

	private static Stream<Arguments> provideSubtractMoney() {
		return Stream.of(
			Arguments.of(Money.ZERO, Money.ZERO, Money.ZERO),
			Arguments.of(Money.wons(200), Money.wons(100), Money.wons(100)),
			Arguments.of(Money.wons(100), Money.wons(200), Money.ZERO)
		);
	}

	private static Stream<Arguments> provideMoneyPairs() {
		return Stream.of(
			Arguments.of(Money.ZERO, Money.wons(0)),
			Arguments.of(Money.wons(100), Money.wons(100)),
			Arguments.of(Money.wons(1000), Money.wons(1000))
		);
	}

	@ParameterizedTest
	@MethodSource("provideMoneyPairs")
	void 금액이_같으면_서로_같은_객체이다(Money money, Money other) {
		assertThat(money).isEqualTo(other);
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, -100, Integer.MIN_VALUE})
	void 금액은_0보다_작을_수_없다(int amount) {
		assertThatThrownBy(() -> Money.wons(amount))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@MethodSource("provideSubtractMoney")
	void 금액은_서로_뺄_수_있다(Money money, Money other, Money result) {
		Money subtractedMoney = money.subtract(other);
		assertThat(subtractedMoney).isEqualTo(result);
	}
}
