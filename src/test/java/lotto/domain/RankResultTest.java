package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.dto.PrizeReport;

class RankResultTest {

	@Test
	@DisplayName("당첨 결과 확인")
	void check_rankResult() {
		RankResult rankResult = new RankResult();
		rankResult.setUp(Rank.FIRST);
		rankResult.setUp(Rank.SECOND);
		rankResult.setUp(Rank.FOURTH);
		rankResult.setUp(Rank.FOURTH);

		assertThat(rankResult.getReport()).contains(
			new PrizeReport(Rank.FIRST, 1, false),
			new PrizeReport(Rank.SECOND, 1, true),
			new PrizeReport(Rank.FOURTH, 2, false));
	}

	@Test
	@DisplayName("수익률 계산: 소수 셋째 자리 내림")
	void calculate_rate() {
		RankResult rankResult = new RankResult();
		rankResult.setUp(Rank.FIFTH);

		assertThat(rankResult.compileStatistics(14000)).isEqualTo(0.35);
	}
}
