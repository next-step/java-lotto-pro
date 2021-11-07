package lotto2.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PurchaseTest {

	@ParameterizedTest
	@CsvSource(value = {"1000,1", "13000, 13", "0,0"}, delimiter = ',')
	@DisplayName("구입금액을 입력받아, 구매 가능한 갯수를 계산한다")
	public void calculateCountTest(int moneyNumber, int expected) {
		// given
		Money money = Money.of(moneyNumber);

		// when
		PositiveNumber count = Purchase.calculateCount(money);

		// then
		assertThat(count).isEqualTo(PositiveNumber.of(expected));
	}
}
