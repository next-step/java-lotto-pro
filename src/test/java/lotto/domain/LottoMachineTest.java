package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LottoMachineTest {

	@Test
	public void 로또_숫자_생성_크기_비교() {
		LottoMachine lottoMachine = new LottoMachine();
		Lottos lottos = lottoMachine.buySeveralLottoTickets(new PurchaseAmount(6000));

		int lottoNumberSize = lottos.quantity();

		assertThat(lottoNumberSize).isEqualTo(6);
	}
}
