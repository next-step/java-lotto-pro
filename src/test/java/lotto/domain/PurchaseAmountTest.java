package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PurchaseAmountTest {

	@Test
	@DisplayName("구매금액이 숫자가 아닌 경우 검증 테스트")
	public void PurchaseAmountTypeTest() {
		assertThatThrownBy(() -> new PurchaseAmount("천만원"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 구매금액은 숫자만 입력가능합니다.");
	}

	@Test
	@DisplayName("구매금액이 1000원 이하인지 검증 테스트")
	public void PurchaseAmountTest() {
		assertThatThrownBy(() -> new PurchaseAmount("999"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 구매금액은 최소 1000원 이상입니다.");
	}

	@ParameterizedTest
	@CsvSource(value = {"4501|4", "2222|2", "2000|2", "14333|14", "7899|7"}, delimiter = '|')
	@DisplayName("로또 구매 시 수량 확인 테스트")
	public void PurchaseAmountPurchaseTest(String inputValue, int expectedValue) {
		//given
		PurchaseAmount purchaseAmount = new PurchaseAmount(inputValue);
		//when
		int purchaseQuantity = purchaseAmount.purchase();
		//then
		assertThat(purchaseQuantity).isEqualTo(expectedValue);
	}
}