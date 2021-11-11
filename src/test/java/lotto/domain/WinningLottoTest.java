package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

	@Test
	@DisplayName("")
	public void WinningLottoTest() {
		//given
		WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6", 9);
		//when
		Rank rank = winningLotto.getRank(new Lotto(1, 2, 3, 4, 5, 9));
		//then
		assertThat(rank).isEqualTo(Rank.SECOND);
	}

}