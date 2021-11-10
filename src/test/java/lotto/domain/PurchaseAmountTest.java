package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountTest {

	@DisplayName("지불 금액에 따른 숫자반환")
	@ParameterizedTest
	@CsvSource(value = {"15000:15", "12000:12"}, delimiter = ':')
	void purchaseQuantity(int money, int purchaseQuantity) {
		PurchaseAmount purchaseAmount = new PurchaseAmount(money);

		int result = purchaseAmount.getPurchaseQuantity();

		assertThat(result).isEqualTo(purchaseQuantity);
	}

	@DisplayName("판매금액과 구입금액이 나누어지지 않는 경우")
	@ParameterizedTest
	@ValueSource(ints = {1200, 555, 333, 10001})
	void invalidPurchaseAmount(int money) {
		assertThatThrownBy(() -> new PurchaseAmount(money))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("로또 한장에 1000원 입니다. 금액을 확인해주세요.");
	}

	@DisplayName("판매 금액 반환")
	@Test
	void getAmount() {
		PurchaseAmount purchaseAmount = new PurchaseAmount(10000);

		int result = purchaseAmount.getAmount();

		assertThat(result).isEqualTo(10000);
	}
}
