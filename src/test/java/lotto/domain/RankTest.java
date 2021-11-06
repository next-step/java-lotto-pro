package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RankTest {
	@Test
	void 로또_1등_당첨() {
		Rank rank = Rank.rank(6);
		assertThat(rank).isEqualTo(Rank.FIRST_PLACE);
	}

	@Test
	void 로또_1등_당첨_금액() {
		Rank rank = Rank.rank(6);

		String prizeMoney = rank.getPrizeMoney();

		assertThat(prizeMoney).isEqualTo("200000000000");
	}

	@Test
	void 로또_2등_당첨() {
		Rank rank = Rank.rank(5);
		assertThat(rank).isEqualTo(Rank.SECOND_PLACE);
	}

	@Test
	void 로또_3등_당첨() {
		Rank rank = Rank.rank(4);
		assertThat(rank).isEqualTo(Rank.THIRD_PLACE);
	}

	@Test
	void 로또_4등_당첨() {
		Rank rank = Rank.rank(3);
		assertThat(rank).isEqualTo(Rank.FOURTH_PLACE);
	}

	@Test
	void 로또_낙첨() {
		Rank rank = Rank.rank(0);
		assertThat(rank).isEqualTo(Rank.FAILED);
	}
}
