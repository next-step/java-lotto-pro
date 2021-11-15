package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
	@DisplayName("로또 생성 크기 비교")
	@Test
	public void getPurchaseQuantity() {
		int lottoCount = 5;
		LottoMachine lottoMachine = new LottoMachine();
		Lottos lottos = lottoMachine.generateAutoLottos(lottoCount);

		int lottoQuantity = lottos.quantity();

		assertThat(lottoQuantity).isEqualTo(lottoCount);
	}
}
