package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.UserMoney;

public class LottoTest {
	private Lotto lotto;

	@BeforeEach
	void setUp() {
		lotto = new Lotto();
	}

	@Test
	@DisplayName("로또 구입 테스트")
	void buy_lotto() {
		assertThat(lotto.buyAutoLotto(new UserMoney("1000"))).hasSize(1);
	}

	@Test
	@DisplayName("로또 당첨 테스트")
	void winning_check_lotto() {
		lotto.buyAutoLotto(new UserMoney("1000"));
		assertThat(lotto.winningList("1,2,3,4,5,6"));
	}
}
