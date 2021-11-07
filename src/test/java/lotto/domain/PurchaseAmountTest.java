package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {

	@Test
	public void getPurchaseQuantity_지불_금액에_따른_숫자반환() {
		PurchaseAmount purchaseAmount = new PurchaseAmount(15000);
		int result = purchaseAmount.getPurchaseQuantity();
		assertThat(result).isEqualTo(15);
	}

	@Test
	public void purchaseAmount_판매금액과_구매금액이_나누어지지_않는_경우() {
		assertThatThrownBy(() ->
			new PurchaseAmount(18500)
		).isInstanceOf(IllegalArgumentException.class);
	}
}
