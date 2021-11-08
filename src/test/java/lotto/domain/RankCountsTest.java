package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankCountsTest {

	@Test
	@DisplayName("순위와 갯수로 생성할 수 있다")
	public void ofTest() {
		// given
		Map<Rank, Integer> rankAndCount = new HashMap<>();
		rankAndCount.put(Rank.THIRD, 1);
		rankAndCount.put(Rank.FIRST, 0);
		rankAndCount.put(Rank.FOURTH, 2);

		// when
		RankCounts rankCounts = RankCounts.of(rankAndCount);
		// then
		assertThat(rankCounts).isEqualTo(RankCounts.of(rankAndCount));
	}
}
