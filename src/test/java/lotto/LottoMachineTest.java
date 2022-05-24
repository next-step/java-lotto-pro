package lotto;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lotto.model.LottoNumbers;
import lotto.model.Lottos;

public class LottoMachineTest {

	private LottoMachine lottoMachine;
	private int userCoin;

	@BeforeEach
	void setUp() {
		lottoMachine = new LottoMachine();
		userCoin = lottoMachine.tradeCoin("10000");
	}

	@Test
	void 구매_실패_테스트() {
		int userCoin = lottoMachine.tradeCoin("1000");

		List<LottoNumbers> lottos = new ArrayList<>();
		lottos.add(new LottoNumbers("1,2,3,4,5,6"));
		lottos.add(new LottoNumbers("1,2,3,4,5,7"));

		assertAll(() -> assertThrows(IllegalArgumentException.class, () -> lottoMachine.isCanBuyLotto(userCoin, "2")),
				() -> assertThrows(IllegalArgumentException.class, () -> lottoMachine.buyLottos(userCoin, lottos)));
	}

	@Test
	void buy_lotto_수동_0장_구매() {
		List<LottoNumbers> lottos = new ArrayList<>();
		Lottos manualLottos = lottoMachine.buyLottos(userCoin, lottos);
		assertEquals(manualLottos.size(), 10);
	}

	@Test
	void buy_lotto_수동_4장_구매() {
		List<LottoNumbers> lottos = new ArrayList<>();
		lottos.add(new LottoNumbers("1,2,3,4,5,6"));
		lottos.add(new LottoNumbers("1,2,3,4,5,7"));
		lottos.add(new LottoNumbers("1,2,3,4,5,8"));
		lottos.add(new LottoNumbers("1,2,3,4,5,9"));

		Lottos manualLottos = lottoMachine.buyLottos(userCoin, lottos);
		assertEquals(manualLottos.size(), 10);
	}

	@Test
	void buy_lotto_수동전체구매() {
		List<LottoNumbers> lottos = new ArrayList<>();
		lottos.add(new LottoNumbers("1,2,3,4,5,6"));
		lottos.add(new LottoNumbers("1,2,3,4,5,7"));
		lottos.add(new LottoNumbers("1,2,3,4,5,8"));
		lottos.add(new LottoNumbers("1,2,3,4,5,9"));
		lottos.add(new LottoNumbers("1,2,3,4,5,9"));
		lottos.add(new LottoNumbers("1,2,3,4,5,6"));
		lottos.add(new LottoNumbers("1,2,3,4,5,7"));
		lottos.add(new LottoNumbers("1,2,3,4,5,8"));
		lottos.add(new LottoNumbers("1,2,3,4,5,9"));
		lottos.add(new LottoNumbers("1,2,3,4,5,9"));

		Lottos manualLottos = lottoMachine.buyLottos(userCoin, lottos);
		assertEquals(manualLottos.size(), 10);
	}
}
