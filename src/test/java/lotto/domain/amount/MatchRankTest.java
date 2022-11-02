package lotto.domain.amount;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatchRankTest {
	@Test
	void 일치_갯수로_당첨금_생성() {
		assertThat(MatchRank.getWinningPrice(3)).isEqualTo(5000L);
		assertThat(MatchRank.getWinningPrice(4)).isEqualTo(50000L);
		assertThat(MatchRank.getWinningPrice(5)).isEqualTo(1500000L);
		assertThat(MatchRank.getWinningPrice(6)).isEqualTo(2000000000L);
	}

	@Test
	void 두개_이하_일치시_당첨금_0원() {
		assertThat(MatchRank.getWinningPrice(2)).isEqualTo(0L);
		assertThat(MatchRank.getWinningPrice(1)).isEqualTo(0L);
		assertThat(MatchRank.getWinningPrice(0)).isEqualTo(0L);
	}
}
