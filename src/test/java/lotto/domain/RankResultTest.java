package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.dto.PrizeReport;

class RankResultTest {
	@Test
	@DisplayName("당첨 결과 확인")
	void check_rankResult() {
		Map<Rank, Long> countingResult = new HashMap<>();
		countingResult.put(Rank.FIRST, 1L);
		countingResult.put(Rank.SECOND, 1L);
		countingResult.put(Rank.FOURTH, 2L);
		RankResult rankResult = new RankResult(countingResult);

		assertThat(rankResult.getReport()).contains(
			new PrizeReport(Rank.FIRST, 1, false),
			new PrizeReport(Rank.SECOND, 1, true),
			new PrizeReport(Rank.FOURTH, 2, false));
	}

	@Test
	@DisplayName("수익률 계산: 소수 셋째 자리 내림")
	void calculate_rate() {
		Map<Rank, Long> countingResult = new HashMap<>();
		countingResult.put(Rank.FIFTH, 1L);
		RankResult rankResult = new RankResult(countingResult);

		assertThat(rankResult.compileStatistics(14000)).isEqualTo(0.35);
	}
}
