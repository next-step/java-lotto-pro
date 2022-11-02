package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatchRankTest {
	@Test
	void 일치_갯수로_당첨등수_생성() {
		assertThat(MatchRank.valueOfMatchCount(3)).isEqualTo(MatchRank.THREE_MATCH);
		assertThat(MatchRank.valueOfMatchCount(4)).isEqualTo(MatchRank.FOUR_MATCH);
		assertThat(MatchRank.valueOfMatchCount(5)).isEqualTo(MatchRank.FIVE_MATCH);
		assertThat(MatchRank.valueOfMatchCount(6)).isEqualTo(MatchRank.SIX_MATCH);
	}

	@Test
	void 두개_이하_일치시_당첨_실패() {
		assertThat(MatchRank.valueOfMatchCount(2)).isEqualTo(MatchRank.FAILED);
		assertThat(MatchRank.valueOfMatchCount(1)).isEqualTo(MatchRank.FAILED);
		assertThat(MatchRank.valueOfMatchCount(0)).isEqualTo(MatchRank.FAILED);
	}
}
