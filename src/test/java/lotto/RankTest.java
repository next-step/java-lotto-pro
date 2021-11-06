package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

	@DisplayName("순위 1,2,3,4,5,miss 검증")
	@Test
	public void rankAllSuccess() {
	    assertAll(() -> {
			assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
			assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST);
			assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
			assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
			assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH);
			assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
			assertThat(Rank.valueOf(3, true)).isEqualTo(Rank.FIFTH);
			assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
			assertThat(Rank.valueOf(2, true)).isEqualTo(Rank.MISS);
			assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.MISS);
		});
	}

}