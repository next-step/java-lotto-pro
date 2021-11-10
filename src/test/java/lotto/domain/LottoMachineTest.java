package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoMachineTest {
	@DisplayName("로또 생성 크기 비교")
	@ParameterizedTest
	@CsvSource(value = {"5000:5", "10000:10", "1000:1"}, delimiter = ':')
	public void getPurchaseQuantity(int money, int purchaseQuantity) {
		LottoMachine lottoMachine = new LottoMachine();
		Lottos manualLottos = new Lottos(new ArrayList<>());
		ManualNumber manualNumber = new ManualNumber(0);
		PurchaseAmount purchaseAmount = new PurchaseAmount(money);
		Buyer buyer = new Buyer(purchaseAmount, manualNumber, manualLottos);

		Lottos lottos = lottoMachine.generateLottos(buyer);

		int lottoNumberSize = lottos.quantity();

		assertThat(lottoNumberSize).isEqualTo(purchaseQuantity);
	}
}
