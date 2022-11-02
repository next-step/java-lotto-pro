package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class RanksTest {

	@Test
	void 순위들의_총_수익을_구한다() {
		Ranks ranks = new Ranks(
			Arrays.asList(
				Rank.FOURTH,
				Rank.FOURTH,
				Rank.SECOND
			)
		);

		assertThat(ranks.getTotalPrize()).isEqualTo(new Money(30_100_000L));
	}

	@Test
	void 수익률을_구한다() {
		Ranks ranks = new Ranks(
			Arrays.asList(
				Rank.FIFTH,
				Rank.MISS,
				Rank.MISS,
				Rank.MISS,
				Rank.MISS,
				Rank.MISS,
				Rank.MISS,
				Rank.MISS,
				Rank.MISS,
				Rank.MISS,
				Rank.MISS,
				Rank.MISS,
				Rank.MISS,
				Rank.MISS
			)
		);

		assertThat(ranks.getIncomeRatio()).isEqualTo(0.35f);
	}

	@Test
	void 각_순위의_갯수를_구한다() {
		Ranks ranks = new Ranks(
			Arrays.asList(
				Rank.FIRST,
				Rank.SECOND,
				Rank.THIRD,
				Rank.FOURTH
			)
		);

		assertThat(ranks.count(Rank.FIRST)).isEqualTo(1L);
		assertThat(ranks.count(Rank.SECOND)).isEqualTo(1L);
		assertThat(ranks.count(Rank.THIRD)).isEqualTo(1L);
		assertThat(ranks.count(Rank.FOURTH)).isEqualTo(1L);
	}

}
