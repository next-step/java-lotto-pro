package model;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {
	@Test
	@DisplayName("14000원 만큼 구매해서 숫자 3개가 일치한 경우 한 번, 수익률은 0.35")
	void 당첨결과에_따른_수익률1() {
		MatchResult matchResult = new MatchResult(1, 0, 0, 0);
		BigDecimal result = LottoStatistics.calculateForEarningsRate(matchResult, 14000);

		assertThat(result).isEqualTo(BigDecimal.valueOf(0.35));
	}

	@Test
	@DisplayName("1000원 만큼 구매해서 숫자 6개가 일치한 경우 한 번, 수익률은 2000000")
	void 당첨결과에_따른_수익률2() {
		MatchResult matchResult = new MatchResult(0, 0, 0, 1);
		BigDecimal result = LottoStatistics.calculateForEarningsRate(matchResult, 1000);

		assertThat(result).isEqualByComparingTo(BigDecimal.valueOf(2_000_000));
	}

	@Test
	@DisplayName("1000원 만큼 구매해서 숫자 5개가 일치한 경우 한 번, 수익률은 1500")
	void 당첨결과에_따른_수익률3() {
		MatchResult matchResult = new MatchResult(0, 0, 1, 0);
		BigDecimal result = LottoStatistics.calculateForEarningsRate(matchResult, 1000);

		assertThat(result).isEqualByComparingTo(BigDecimal.valueOf(1500));
	}

	@Test
	@DisplayName("1000원 만큼 구매해서 숫자 4개가 일치한 경우 한 번, 수익률은 1500")
	void 당첨결과에_따른_수익률4() {
		MatchResult matchResult = new MatchResult(0, 1, 0, 0);
		BigDecimal result = LottoStatistics.calculateForEarningsRate(matchResult, 1000);

		assertThat(result).isEqualByComparingTo(BigDecimal.valueOf(50));
	}

	@Test
	@DisplayName("1000원 만큼 구매해서 숫자 3개가 일치한 경우 한 번, 수익률은 5")
	void 당첨결과에_따른_수익률5() {
		MatchResult matchResult = new MatchResult(1, 0, 0, 0);
		BigDecimal result = LottoStatistics.calculateForEarningsRate(matchResult, 1000);

		assertThat(result).isEqualByComparingTo(BigDecimal.valueOf(5));
	}

	@Test
	@DisplayName("20000원 만큼 구매해서 3개:5번, 4개:1번, 5개:1번 일치한 경우 수익률은 78.75")
	void 당첨결과에_따른_수익률6() {
		MatchResult matchResult = new MatchResult(5, 1, 1, 0);
		BigDecimal result = LottoStatistics.calculateForEarningsRate(matchResult, 20000);

		assertThat(result).isEqualByComparingTo(BigDecimal.valueOf(78.75));
	}
}