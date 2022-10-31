package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("순위 collection 테스트")
class RanksTest {

	@Test
	@DisplayName("순위 collection 생성")
	void createRanks() {
		Ranks ranks = Ranks.from(List.of(6, 5, 3));
		assertThat(ranks).isInstanceOf(Ranks.class);
	}

	@Test
	@DisplayName("FOURTH 부터 역순으로 정렬 된 순위 별 개수 map 반환")
	void groupByTest() {
		// given
		Ranks ranks = Ranks.from(List.of(6, 5, 4, 6, 6));

		LinkedHashMap<Rank, Long> expected = new LinkedHashMap<>();
		expected.put(Rank.FOURTH, 0L);
		expected.put(Rank.THIRD, 1L);
		expected.put(Rank.SECOND, 1L);
		expected.put(Rank.FIRST, 3L);

		// when
		Map<Rank, Long> groupBy = ranks.groupBy();

		// then
		assertThat(groupBy).containsExactlyEntriesOf(expected);
	}

}