package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

	@Test
	@DisplayName("값이 주어지면 몇등인지 맞추기 테스트")
	public void RankTest() {
		assertAll(
			() -> assertThat(Rank.checkRank(6, false)).isEqualTo(Rank.FIRST),
			() -> assertThat(Rank.checkRank(5, true)).isEqualTo(Rank.SECOND),
			() -> assertThat(Rank.checkRank(5, false)).isEqualTo(Rank.THIRD),
			() -> assertThat(Rank.checkRank(4, true)).isEqualTo(Rank.FOURTH),
			() -> assertThat(Rank.checkRank(3, true)).isEqualTo(Rank.FIFTH),
			() -> assertThat(Rank.checkRank(0, true)).isEqualTo(Rank.MISS)
		);
	}
}