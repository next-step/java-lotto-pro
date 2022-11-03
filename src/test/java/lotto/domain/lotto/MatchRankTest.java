package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatchRankTest {
	@Test
	void 일치_갯수로_당첨등수_생성() {
		assertThat(MatchRank.valueOf(3, false)).isEqualTo(MatchRank.FIFTH);
		assertThat(MatchRank.valueOf(4, false)).isEqualTo(MatchRank.FOURTH);
		assertThat(MatchRank.valueOf(5, false)).isEqualTo(MatchRank.THIRD);
		assertThat(MatchRank.valueOf(6, false)).isEqualTo(MatchRank.FIRST);
	}

	@Test
	void 두개_이하_일치시_당첨_실패() {
		assertThat(MatchRank.valueOf(2, false)).isEqualTo(MatchRank.FAILED);
		assertThat(MatchRank.valueOf(1, false)).isEqualTo(MatchRank.FAILED);
		assertThat(MatchRank.valueOf(0, false)).isEqualTo(MatchRank.FAILED);
	}

	@Test
	void 다섯개_보너스_번호_일치() {
		assertThat(MatchRank.valueOf(5, true)).isEqualTo(MatchRank.SECOND);
	}

	@Test
	void 일치갯수_0미만시_IllegalArgumentException() {
		assertThatThrownBy(() -> MatchRank.valueOf(-1, false))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
