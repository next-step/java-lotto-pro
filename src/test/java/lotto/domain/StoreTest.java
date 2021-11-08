package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.exception.LackOfMoneyException;

class StoreTest {
	@ParameterizedTest
	@ValueSource(ints = {900, 0, 500})
	@DisplayName("구매 금액이 부족한 경우 예외를 발생한다.")
	void testPurchaseMoneyLack(int input) {
		assertThatExceptionOfType(LackOfMoneyException.class)
			.isThrownBy(() -> Store.order(new Money(input)));
	}

	@ParameterizedTest
	@CsvSource(value = {"10000;10", "1500;1", "3900;3"}, delimiter = ';')
	@DisplayName("구매 금액 범위 내에서 최대한 구매할 수 있다.")
	void testPurchasedLottoCount(int input, int expected) {
		Money money = new Money(input);
		Lottos lottos = Store.order(money);
		assertThat(lottos.size()).isEqualTo(expected);
	}
}