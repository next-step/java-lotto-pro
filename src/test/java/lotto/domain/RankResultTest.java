package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("순위 결과 테스트")
class RankResultTest {

	@Test
	@DisplayName("순위 결과 생성")
	void createResult() {
		Ranks ranks = Ranks.from(List.of(Rank.SECOND));
		RankResult rankResult = ranks.rankResults();
		assertThat(rankResult).isInstanceOf(RankResult.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"50000, 1", "100000, 0.5", "10000, 5", "30000, 1.67"}, delimiter = ',')
	@DisplayName("수익률 반환 테스트")
	void profitTest(Long inputMoney, Double expected) {
		// given
		Ranks ranks = Ranks.from(List.of(Rank.FOURTH));
		RankResult rankResult = ranks.rankResults();

		// when
		double profitRate = rankResult.profitRate(Money.from(inputMoney));

		// then
		assertThat(profitRate).isEqualTo(expected);
	}

}