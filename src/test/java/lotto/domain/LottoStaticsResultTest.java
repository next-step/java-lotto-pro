package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStaticsResultTest {

	@Test
	@DisplayName("랭크집계와 수익률이 주어지면, 생성할 수 있다")
	public void ofTest() {
		// given
		Map<Rank, Integer> rankAndCount = new HashMap<>();
		rankAndCount.put(Rank.THIRD, 1);
		rankAndCount.put(Rank.FIRST, 0);
		rankAndCount.put(Rank.FOURTH, 2);
		RankCounts rankCounts = RankCounts.of(rankAndCount);
		double profit = 0.5D;
		// when
		LottoStaticsResult result = LottoStaticsResult.of(rankCounts, profit);

		// then
		assertThat(result).isEqualTo(LottoStaticsResult.of(rankCounts, profit));
	}
}
