package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatchCountWinningPriceStrategyTest {

	@Test
	void 일치_갯수로_당첨금_생성() {
		assertThat(new MatchCountWinningPriceStrategy(MatchCount.from(3)).winningPrice()).isEqualTo(Price.from(5000L));
		assertThat(new MatchCountWinningPriceStrategy(MatchCount.from(4)).winningPrice()).isEqualTo(Price.from(50000L));
		assertThat(new MatchCountWinningPriceStrategy(MatchCount.from(5)).winningPrice()).isEqualTo(
			Price.from(1500000L));
		assertThat(new MatchCountWinningPriceStrategy(MatchCount.from(6)).winningPrice()).isEqualTo(
			Price.from(2000000000L));
	}

	@Test
	void 두개_이하_일치시_당첨금_0원() {
		assertThat(new MatchCountWinningPriceStrategy(MatchCount.from(2)).winningPrice()).isEqualTo(Price.from(0L));
		assertThat(new MatchCountWinningPriceStrategy(MatchCount.from(1)).winningPrice()).isEqualTo(Price.from(0L));
		assertThat(new MatchCountWinningPriceStrategy(MatchCount.from(0)).winningPrice()).isEqualTo(Price.from(0L));
	}
}
