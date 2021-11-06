package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPrizesTest {

	@Test
	@DisplayName("여러 순위들이 주어지면, 총 당첨금을 계산한다")
	public void getTotalPrizeTest() {
		// given
		LottoRanks ranks = new LottoRanks(Arrays.asList(
			new LottoRank(4),
			new LottoRank(4)));

		// when
		LottoPrizes prizes = new LottoPrizes(ranks);

		// then
		assertThat(prizes.getTotalPrizeMoney()).isEqualTo(10_000);
	}
}
