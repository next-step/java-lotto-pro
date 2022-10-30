package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RankTest {

	@Test
	void 갯수별_순위를_구한다() {
		Assertions.assertThat(Rank.match(6, false)).isEqualTo(Rank.FIRST);
		Assertions.assertThat(Rank.match(5, true)).isEqualTo(Rank.SECOND);
		Assertions.assertThat(Rank.match(5, false)).isEqualTo(Rank.THIRD);
		Assertions.assertThat(Rank.match(4, false)).isEqualTo(Rank.FOURTH);
		Assertions.assertThat(Rank.match(3, false)).isEqualTo(Rank.FIFTH);
		Assertions.assertThat(Rank.match(2, false)).isEqualTo(Rank.MISS);
	}
}
