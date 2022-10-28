package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class RanksTest {

	@Test
	void 순위들의_총_수익을_구한다(){
		Ranks ranks = new Ranks(
			Arrays.asList(
				Rank.FOURTH,
				Rank.FOURTH,
				Rank.SECOND
			)
		);

		assertThat(ranks.getTotalPrize()).isEqualTo(1_510_000L);
	}

}
