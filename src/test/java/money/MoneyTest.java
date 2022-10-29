package money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

	@ParameterizedTest
	@MethodSource("동일_금액_입력")
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
	@MethodSource("뺄셈_금액_입력")
	void 금액은_서로_뺄_수_있다(Money money, Money other, Money result) {
		Money subtractedMoney = money.subtract(other);
		assertThat(subtractedMoney).isEqualTo(result);
	}

	@ParameterizedTest
	@MethodSource("나눗셈_금액_입력")
	void 금액은_서로_나눌_수_있다(Money 금액, Money 나누는_금액, BigDecimal 나눗셈_결과) {
		assertThat(금액.divideBy(나누는_금액)).isEqualTo(나눗셈_결과);
	}

	@ParameterizedTest
	@MethodSource("금액_곱셈_입력")
	void 금액을_곱할_수_있다(Money 금액, int 곱셈수, Money 곱셈_결과) {
		assertThat(금액.multiply(곱셈수)).isEqualTo(곱셈_결과);
	}

	@ParameterizedTest
	@MethodSource("뺄셈_금액_예외_입력")
	void 더_작은_금액을_큰_금액으로_뺄_수_없다(Money 금액, Money 뺄셈_금액) {
		assertThatThrownBy(() -> 금액.subtract(뺄셈_금액))
			.isInstanceOf(IllegalArgumentException.class);
	}

	private static Stream<Arguments> 동일_금액_입력() {
		return Stream.of(
			Arguments.of(Money.ZERO, Money.wons(0)),
			Arguments.of(Money.wons(100), Money.wons(100)),
			Arguments.of(Money.wons(1000), Money.wons(1000))
		);
	}

	private static Stream<Arguments> 뺄셈_금액_입력() {
		return Stream.of(
			Arguments.of(Money.ZERO, Money.ZERO, Money.ZERO),
			Arguments.of(Money.wons(200), Money.wons(100), Money.wons(100)),
			Arguments.of(Money.wons(200), Money.wons(200), Money.ZERO)
		);
	}

	private static Stream<Arguments> 나눗셈_금액_입력() {
		return Stream.of(
			Arguments.of(Money.wons(1000), Money.wons(1000), createBigDecimal(1)),
			Arguments.of(Money.wons(3000), Money.wons(1000), createBigDecimal(3)),
			Arguments.of(Money.wons(1000), Money.wons(3000), createBigDecimal(0.33))
		);
	}

	private static BigDecimal createBigDecimal(double value) {
		return BigDecimal.valueOf(value).setScale(2, RoundingMode.DOWN);
	}

	private static Stream<Arguments> 금액_곱셈_입력() {
		return Stream.of(
			Arguments.of(Money.ZERO, 100, Money.wons(0)),
			Arguments.of(Money.wons(100), 1, Money.wons(100)),
			Arguments.of(Money.wons(1000), 3, Money.wons(3000))
		);
	}

	private static Stream<Arguments> 뺄셈_금액_예외_입력() {
		return Stream.of(
			Arguments.of(Money.ZERO, Money.wons(100)),
			Arguments.of(Money.wons(100), Money.wons(1000))
		);
	}
}
