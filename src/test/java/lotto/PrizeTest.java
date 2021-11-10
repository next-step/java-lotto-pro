package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.constants.LottoConstants;
import lotto.constants.Rank;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.Lottos;
import lotto.model.Prize;

public class PrizeTest {
	Lotto lotto1;
	Lotto lotto2;
	Lotto winLotto;

	@BeforeEach
	void setUp() {
		lotto1 = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
		lotto2 = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 10));
		winLotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
	}

	@Test
	@DisplayName("게임 진행시 Prize 생성되는 테스트")
	void generate() {
		LottoGame game = new LottoGame(winLotto);
		Prize prize = game.winPrize(new Lottos(Arrays.asList(lotto1, lotto2)));

		assertThat(prize).isEqualTo(
			new Prize(winLotto.compare(lotto1), winLotto.compare(lotto2)));
	}

	@Test
	@DisplayName("당첨된 로또들의 상금액과 수익률을 계산하는 테스트")
	void winPrize() {
		Prize prize = new Prize(Rank.FIRST, Rank.THIRD);

		assertThat(prize.winMoney()).isEqualTo(Rank.FIRST.getPrize() + Rank.THIRD.getPrize());
		assertThat(prize.rateReturn(2 * LottoConstants.PRICE)).isEqualTo(
			(Rank.FIRST.getPrize() + Rank.THIRD.getPrize()) / (2.0 * LottoConstants.PRICE));
	}
}
