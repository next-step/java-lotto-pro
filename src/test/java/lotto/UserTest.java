package lotto;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.LottoMachine;
import lotto.User;
import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import lotto.model.UserMoney;

public class UserTest {
	private LottoMachine lottoMachine;

	@BeforeEach
	void setup() {
		lottoMachine = new LottoMachine();
	}

	@Test
	@DisplayName("수동 로또 구입 예외 테스트")
	void manual_lotto_fail() {
		User user = new User(new UserMoney("1000"));
		assertThrows(IllegalArgumentException.class, () -> user.isCanBuyLotto(lottoMachine, "2"));
	}

	@Test
	@DisplayName("수동 로또 구입 예외 테스트")
	void buy_manual_lotto() {
		User user = new User(new UserMoney("2000"));
		user.isCanBuyLotto(lottoMachine, "2");

		List<LottoNumbers> manualLottos = new ArrayList<>();
		manualLottos.add(new LottoNumbers("1,2,3,4,5,6"));
		manualLottos.add(new LottoNumbers("1,2,3,4,5,7"));
		user.buyManualLottos(lottoMachine, new Lottos(manualLottos));

		assertAll(() -> assertEquals(user.getManualLottos().size(), 2),
				() -> assertEquals(user.getUserMoney().getMoney(), 0));
	}

	@Test
	@DisplayName("자동 로또 구입 예외 테스트")
	void buy_auto_lotto() {
		User user = new User(new UserMoney("3000"));
		user.isCanBuyLotto(lottoMachine, "0");
		user.buyAutoLottos(lottoMachine);

		assertAll(() -> assertEquals(user.getAutoLottos().size(), 3),
				() -> assertEquals(user.getUserMoney().getMoney(), 0));

	}
}
