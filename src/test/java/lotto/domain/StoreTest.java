package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.exception.LackOfMoneyException;

class StoreTest {

	private List<List<Integer>> manualNumbers;

	@BeforeEach
	void setUp() {
		manualNumbers = Arrays.asList(
			Arrays.asList(1, 2, 3, 4, 5, 6),
			Arrays.asList(21, 21, 23, 24, 25, 26)
		);
	}

	@ParameterizedTest
	@ValueSource(ints = {900, 0, 700})
	@DisplayName("최소 금액 보다 부족한 경우 예외를 발생한다.")
	void testNotAllowPurchaseMinimumMoney(int input) {
		assertThatExceptionOfType(LackOfMoneyException.class)
			.isThrownBy(() -> Store.order(new Money(input), new ArrayList<>()));
	}

	@ParameterizedTest
	@ValueSource(ints = {1000, 1500, 1900})
	@DisplayName("보유 금액 이상으로 구매를 시도하는 경우 예외를 발생한다.")
	void testNotAllowOverPurchaseNotEnoughMoney(int input) {
		assertThatExceptionOfType(LackOfMoneyException.class)
			.isThrownBy(() -> Store.order(new Money(input), manualNumbers));
	}

	@ParameterizedTest
	@CsvSource(value = {"10000;10", "2500;2", "3900;3"}, delimiter = ';')
	@DisplayName("구매 금액 범위 내에서 최대한 구매할 수 있다.")
	void testPurchasedLottoCount(int input, int expected) {
		Money money = new Money(input);
		Lottos lottos = Store.order(money, manualNumbers);
		assertThat(lottos.size()).isEqualTo(expected);
	}

	@Test
	@DisplayName("수동으로 로또를 구매할 수 있다.")
	void testManualLottoOrder() {
		Lottos lottos = Store.order(new Money(2000), manualNumbers);
		assertThat(lottos.size()).isEqualTo(2);
	}
}