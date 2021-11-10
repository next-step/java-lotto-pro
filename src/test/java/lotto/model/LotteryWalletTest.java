package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LotteryWalletTest {


	@ParameterizedTest
	@CsvSource(value = {"1000:1","50000:50","12312:12"}, delimiter = ':')
	@DisplayName("금액으로 로또 자동구매(올바른 금액)")
	void purchaseLotto(String strMoney, int lottoCount) {
		LotteryWallet wallet = new LotteryWallet(strMoney, null);
		int purchasedLotto = wallet.numberOfPurchasedLottoTotal();

		assertThat(purchasedLotto).isEqualTo(lottoCount);
	}

	@Test
	@DisplayName("수동구매 + 자동구매(올바른 값)")
	void purchaseAutoAndManual() {
		Lottos manual = new Lottos(4);
		LotteryWallet wallet = new LotteryWallet("15000", manual);
		int purchasedLottoAuto = wallet.numberOfPurchasedLottoAuto();
		int purchasedLottoManual = wallet.numberOfPurchasedLottoManual();

		assertThat(purchasedLottoAuto).isEqualTo(11);
		assertThat(purchasedLottoManual).isEqualTo(4);
	}

	@Test
	@DisplayName("수동구매 + 자동구매(개수 오버)")
	void purchaseAutoAndManualOver() {
		Lottos manual = new Lottos(24);
		assertThatThrownBy(()->{
			@SuppressWarnings("unused")
			LotteryWallet wallet = new LotteryWallet("15000", manual);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
