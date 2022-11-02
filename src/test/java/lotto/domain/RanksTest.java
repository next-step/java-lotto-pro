package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("순위 collection 테스트")
class RanksTest {

	@Test
	@DisplayName("순위 collection 생성")
	void createRanks() {
		Ranks ranks = Ranks.from(List.of(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH));
		assertThat(ranks).isInstanceOf(Ranks.class);
	}

	@Test
	@DisplayName("FOURTH 부터 역순으로 정렬 된 RanksResults 객체 반환")
	void groupByTest() {
		// given
		Ranks ranks = Ranks.from(List.of(Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.SECOND, Rank.THIRD));

		LinkedHashMap<Rank, Long> resultMap = new LinkedHashMap<>();
		resultMap.put(Rank.FIFTH, 0L);
		resultMap.put(Rank.FOURTH, 0L);
		resultMap.put(Rank.THIRD, 1L);
		resultMap.put(Rank.SECOND, 1L);
		resultMap.put(Rank.FIRST, 3L);
		RankResult expected = RankResult.from(resultMap);

		// when
		RankResult rankResult = ranks.rankResults();

		// then
		assertThat(rankResult).isEqualTo(expected);
	}

}