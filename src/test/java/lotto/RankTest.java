package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RankTest {

	@Test
	public void 순위_1등() throws Exception {
	    assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
		assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST);
	}

	@Test
	public void 순위_2등() throws Exception {
		assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
	}

	@Test
	public void 순위_3등() throws Exception {
		assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
	}

	@Test
	public void 순위_4등() throws Exception {
		assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH);
		assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
	}

	@Test
	public void 순위_5등() throws Exception {
		assertThat(Rank.valueOf(3, true)).isEqualTo(Rank.FIFTH);
		assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
	}

	@Test
	public void 순위_없음() throws Exception {
		assertThat(Rank.valueOf(2, true)).isEqualTo(Rank.MISS);
		assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.MISS);
	}
}