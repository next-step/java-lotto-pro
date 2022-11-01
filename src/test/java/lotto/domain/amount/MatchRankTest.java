package lotto.domain.amount;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.domain.match.count.MatchCount;

class MatchRankTest {
	@Test
	void 일치_갯수로_당첨금_생성() {
		assertThat(MatchRank.getWinningPrice(MatchCount.from(3))).isEqualTo(Amount.from(5000L));
		assertThat(MatchRank.getWinningPrice(MatchCount.from(4))).isEqualTo(Amount.from(50000L));
		assertThat(MatchRank.getWinningPrice(MatchCount.from(5))).isEqualTo(Amount.from(1500000L));
		assertThat(MatchRank.getWinningPrice(MatchCount.from(6))).isEqualTo(Amount.from(2000000000L));
	}

	@Test
	void 두개_이하_일치시_당첨금_0원() {
		assertThat(MatchRank.getWinningPrice(MatchCount.from(2))).isEqualTo(Amount.from(0L));
		assertThat(MatchRank.getWinningPrice(MatchCount.from(1))).isEqualTo(Amount.from(0L));
		assertThat(MatchRank.getWinningPrice(MatchCount.from(0))).isEqualTo(Amount.from(0L));
	}
}
