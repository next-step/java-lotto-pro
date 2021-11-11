package lotto.domain;

import static org.assertj.core.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

	@Test
	@DisplayName("")
	public void LottosTest() {
		//given
		Lottos lottos = LottoShop.sell(new Money(5000));
		WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6", 9);
		//when
		int count = lottos.createLottoResult(winningLotto).countLotto();
		//then
		assertThat(count).isEqualTo(5);
	}

}
