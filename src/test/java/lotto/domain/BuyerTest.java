package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyerTest {

	private PurchaseAmount purchaseAmount;

	@BeforeEach
	void setUp() {
		purchaseAmount = new PurchaseAmount(10000);
	}

	@DisplayName("판매자 생성")
	@Test
	void generateBuyer() {
		Buyer buyer = new Buyer(purchaseAmount, 5);

		assertThat(buyer).isEqualTo(new Buyer(purchaseAmount, 5));
	}

	@DisplayName("구입금액보다 많은 수동 횟수인 경우")
	@Test
	void shortMoney() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				new Buyer(purchaseAmount, 11);
			}).withMessageMatching("구입금액이 부족합니다.");
	}
}
