package lotto.domain.wrapper;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HitsByRankTest {

	@DisplayName("로또번호 적중 시 hits 증가")
	@Test
	public void addWhenMatchedNumberCountHitsTest() {
		Rank fifthRank = Rank.FIFTH;

		HitsByRank hitsByRank = new HitsByRank();

		assertThat(hitsByRank.getHitsByRank(fifthRank)).isEqualTo(0);
		hitsByRank.hit(fifthRank);
		assertThat(hitsByRank.getHitsByRank(fifthRank)).isEqualTo(1);
	}
}
