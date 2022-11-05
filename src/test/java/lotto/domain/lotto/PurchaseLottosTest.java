package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.domain.amount.Amount;

class PurchaseLottosTest {

	private static final List<String> manualLottoNumbers = Arrays.asList(
		"1,2,3,4,5,6",
		"2,3,4,5,6,7",
		"3,4,5,6,7,8"
	);

	@Test
	void 예산_소진_확인() {
		assertThat(new PurchaseLottos(Amount.from(0)).isEmptyBudget()).isTrue();
	}

	@Test
	void 수동_로또_구매() {
		PurchaseLottos purchaseLottos = new PurchaseLottos(Amount.from(3000));

		Lottos lottos = purchaseLottos.purchaseManualLottos(manualLottoNumbers);
		assertThat(lottos.getQuantity()).isEqualTo(3);
		assertThat(purchaseLottos.isEmptyBudget()).isTrue();
	}

	@Test
	void 자동_로또_구매() {
		PurchaseLottos purchaseLottos = new PurchaseLottos(Amount.from(5000));
		Lottos lottos = purchaseLottos.purchaseRandomLottos();
		assertThat(lottos.getQuantity()).isEqualTo(5);
		assertThat(purchaseLottos.isEmptyBudget()).isTrue();
	}

	@Test
	void 로또_구매_잔돈_생길수_있을경우_IllegalArugumentException() {
		assertThatThrownBy(() -> new PurchaseLottos(Amount.from(2500)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 수동_구매_로또수_구입금액보다_많을경우_IllegalStateException() {
		PurchaseLottos purchaseLottos = new PurchaseLottos(Amount.from(2000));
		assertThatThrownBy(() -> purchaseLottos.purchaseManualLottos(manualLottoNumbers))
			.isInstanceOf(IllegalStateException.class);
	}
}
