package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoQuantityTest {

	@DisplayName("자동 숫자 확인")
	@Test
	void equalToAutoQuantity() {
		int purchaseQuantity = 4;
		int manualQuantity = 1;
		LottoQuantity lottoQuantity = new LottoQuantity(purchaseQuantity, manualQuantity);

		int autoQuantity = lottoQuantity.getAutoQuantity();

		assertThat(autoQuantity).isEqualTo(3);
	}

	@DisplayName("로또 구매 가능 수 오류")
	@Test
	void validLottoQuantity() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				int purchaseQuantity = 4;
				int manualQuantity = 5;

				new LottoQuantity(purchaseQuantity, manualQuantity);
			}).withMessageMatching("구매가능한 로또 수량을 초과하였습니다.");
	}
}
