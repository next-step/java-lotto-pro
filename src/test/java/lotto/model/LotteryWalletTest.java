package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LotteryWalletTest {


	@ParameterizedTest
	@CsvSource(value = {"1000:1","50000:50","12312:12"}, delimiter = ':')
	@DisplayName("금액으로 로또 구매(올바른 금액)")
	void purchaseLotto(String strMoney, int lottoCount) {
		LotteryWallet wallet = new LotteryWallet(strMoney);
		int purchasedLotto = wallet.numberOfPurchasedLotto();

		assertThat(purchasedLotto).isEqualTo(lottoCount);
	}
}
