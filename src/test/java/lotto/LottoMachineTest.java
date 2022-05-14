package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
