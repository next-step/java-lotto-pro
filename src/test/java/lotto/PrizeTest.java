package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.constants.Rank;
import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.PurchaseMoney;

public class PrizeTest {
	Lotto lotto1;
	Lotto lotto2;
	Lotto winLotto;

	@BeforeEach
	void setUp() {
		lotto1 = new Lotto(4, 5, 6, 7, 8, 9);
		lotto2 = new Lotto(4, 5, 6, 7, 8, 10);
		winLotto = new Lotto(4, 5, 6, 7, 8, 9);
	}

	@Test
	@DisplayName("로또 등수에 따른 총 상금액 계산")
	void winMoney() {
		Prize prize = Prize.withRankList(Arrays.asList(Rank.FIRST, Rank.SECOND));
		assertThat(prize.winMoney()).isEqualTo(Rank.FIRST.getWinningMoney() + Rank.SECOND.getWinningMoney());
	}

	@Test
	@DisplayName("로또 구매 비용과 로또 등수에 따른 총 상금액 간의 비율 계산")
	void winPrize() {
		Prize prize = Prize.withRankList(Arrays.asList(Rank.FIRST, Rank.SECOND));

		assertThat(prize.rateReturn(new PurchaseMoney(3000))).isEqualTo(
			(Rank.FIRST.getWinningMoney() + Rank.SECOND.getWinningMoney()) / 3000.0);
	}

	@Test
	@DisplayName("로또 등수의 개수를 계산할 수 있어야 한다.")
	void rankCount() {
		Prize prize = Prize.withRankList(Arrays.asList(Rank.FIRST, Rank.FIRST, Rank.SECOND, Rank.THIRD));
		assertThat(prize.getCount(Rank.FIRST)).isEqualTo(2);
		assertThat(prize.getCount(Rank.SECOND)).isEqualTo(1);
	}
}
