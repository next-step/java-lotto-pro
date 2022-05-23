package lotto;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import lotto.model.UserMoney;

public class LottoMachineTest {

	private LottoMachine lottoMachine;

	@BeforeEach
	void setUp() {
		lottoMachine = new LottoMachine();
	}

	@Test
	@DisplayName("금액에 맞는 자동 로또 구입")
	void buy_lotto_auto() {
		assertEquals(lottoMachine.buyAutoLottos(new UserMoney("2300")).getLottos().size(), 2);
	}

	@Test
	@DisplayName("수동 로또 구매 금액 초과 오류")
	void buy_lotto_manual_throws() {
		assertAll(() -> assertTrue(lottoMachine.isCanBuyLotto(new UserMoney("2300"), 2)),
				() -> assertFalse(lottoMachine.isCanBuyLotto(new UserMoney("2300"), 3)));
	}

	@Test
	@DisplayName("수동 로또 구매 실패 테스트")
	void buy_lotto_manual_fail() {
		List<LottoNumbers> tempLottos = new ArrayList<>();
		tempLottos.add(new LottoNumbers("1,2,3,4,5,6"));
		tempLottos.add(new LottoNumbers("1,2,3,4,5,7"));
		tempLottos.add(new LottoNumbers("1,2,3,4,5,8"));
		tempLottos.add(new LottoNumbers("1,2,3,4,5,9"));

		Lottos lottos = new Lottos(tempLottos);

		assertThrows(IllegalArgumentException.class, () -> lottoMachine.buyManualLottos(new UserMoney("2300"), lottos));
	}

	@Test
	@DisplayName("수동 로또 구매")
	void buy_lotto_manual() {
		List<LottoNumbers> tempLottos = new ArrayList<>();
		tempLottos.add(new LottoNumbers("1,2,3,4,5,6"));
		tempLottos.add(new LottoNumbers("1,2,3,4,5,7"));
		tempLottos.add(new LottoNumbers("1,2,3,4,5,8"));
		tempLottos.add(new LottoNumbers("1,2,3,4,5,9"));

		Lottos lottos = new Lottos(tempLottos);

		UserMoney userMoney = new UserMoney("4300");
		Lottos manualLottos = lottoMachine.buyManualLottos(userMoney, lottos);

		assertAll(() -> assertEquals(manualLottos.size(), 4), () -> assertEquals(userMoney.getMoney(), 300));
	}
}
