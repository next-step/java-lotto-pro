package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RankTest {

	@Test
	void 갯수별_순위를_구한다() {
		Assertions.assertThat(Rank.from(6)).isEqualTo(Rank.FIRST);
		Assertions.assertThat(Rank.from(5)).isEqualTo(Rank.SECOND);
		Assertions.assertThat(Rank.from(4)).isEqualTo(Rank.THIRD);
		Assertions.assertThat(Rank.from(3)).isEqualTo(Rank.FOURTH);
		Assertions.assertThat(Rank.from(2)).isEqualTo(Rank.MISS);
	}
}
