package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoMachineTest {

	@DisplayName("로또 생성 크기 비교")
	@ParameterizedTest
	@CsvSource(value = {"5000:5", "6000:6", "15000:15"}, delimiter = ':')
	public void getPurchaseQuantity(int money, int purchaseQuantity) {
		LottoMachine lottoMachine = new LottoMachine();
		Lottos lottos = lottoMachine.generateLottos(new PurchaseAmount(money).getPurchaseQuantity());

		int lottoNumberSize = lottos.quantity();

		assertThat(lottoNumberSize).isEqualTo(purchaseQuantity);
	}
}
