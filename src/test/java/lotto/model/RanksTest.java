package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
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

		assertThat(ranks.getTotalPrize()).isEqualTo(new Money(1_510_000L));
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

		Assertions.assertThat(ranks.count(Rank.FIRST)).isEqualTo(1L);
		Assertions.assertThat(ranks.count(Rank.SECOND)).isEqualTo(1L);
		Assertions.assertThat(ranks.count(Rank.THIRD)).isEqualTo(1L);
		Assertions.assertThat(ranks.count(Rank.FOURTH)).isEqualTo(1L);
	}

}
