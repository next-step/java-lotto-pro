package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.PurchaseMoney;

public class PurchaseMoneyTest {

	@Test
	@DisplayName("로또 구매 비용 부족 테스트")
	void generateFailed() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new PurchaseMoney(500);
		});
	}

	@Test
	@DisplayName("비용에 따른 로또 구매 갯수 테스트")
	void purchase() {
		assertThat(new PurchaseMoney(5000).purchase()).isEqualTo(5);
	}
}
