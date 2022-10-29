package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("순위 collection 테스트")
class RanksTest {

	@Test
	@DisplayName("순위 collection 생성")
	void createRanks() {
		Ranks ranks = Ranks.of(List.of(6, 5, 3));
		assertThat(ranks).isInstanceOf(Ranks.class);
	}

	@Test
	@DisplayName("FOURTH 부터 역순으로 정렬 된 순위 별 개수 map 반환")
	void groupByTest() {
		Ranks ranks = Ranks.of(List.of(6, 5, 4, 6, 6));
		Map<Rank, Long> groupBy = ranks.groupBy();
		assertAll(
			() -> assertThat(groupBy).containsEntry(Rank.FOURTH, 0L),
			() -> assertThat(groupBy).containsEntry(Rank.THIRD, 1L),
			() -> assertThat(groupBy).containsEntry(Rank.SECOND, 1L),
			() -> assertThat(groupBy).containsEntry(Rank.FIRST, 3L),
			() -> assertThat(groupBy.keySet().toArray()[0]).isEqualTo(Rank.FOURTH),
			() -> assertThat(groupBy.keySet().toArray()[1]).isEqualTo(Rank.THIRD),
			() -> assertThat(groupBy.keySet().toArray()[2]).isEqualTo(Rank.SECOND),
			() -> assertThat(groupBy.keySet().toArray()[3]).isEqualTo(Rank.FIRST)
		);
	}

}