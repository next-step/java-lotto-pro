package lotto.domain.amount;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.domain.match.count.MatchCount;

class MatchCountWinningAmountStrategyTest {

	@Test
	void 일치_갯수로_당첨금_생성() {
		assertThat(new MatchCountWinningPriceStrategy(MatchCount.from(3)).winningPrice()).isEqualTo(Amount.from(5000L));
		assertThat(new MatchCountWinningPriceStrategy(MatchCount.from(4)).winningPrice()).isEqualTo(
			Amount.from(50000L));
		assertThat(new MatchCountWinningPriceStrategy(MatchCount.from(5)).winningPrice()).isEqualTo(
			Amount.from(1500000L));
		assertThat(new MatchCountWinningPriceStrategy(MatchCount.from(6)).winningPrice()).isEqualTo(
			Amount.from(2000000000L));
	}

	@Test
	void 두개_이하_일치시_당첨금_0원() {
		assertThat(new MatchCountWinningPriceStrategy(MatchCount.from(2)).winningPrice()).isEqualTo(Amount.from(0L));
		assertThat(new MatchCountWinningPriceStrategy(MatchCount.from(1)).winningPrice()).isEqualTo(Amount.from(0L));
		assertThat(new MatchCountWinningPriceStrategy(MatchCount.from(0)).winningPrice()).isEqualTo(Amount.from(0L));
	}
}
