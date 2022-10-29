package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

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
	@DisplayName("순위 별 개수 map 반환")
	void groupByTest() {
		Ranks ranks = Ranks.of(List.of(6, 5, 4, 6, 6));
		assertThat(ranks.groupBy()).containsEntry(Rank.FIRST, 3L);
		assertThat(ranks.groupBy()).containsEntry(Rank.SECOND, 1L);
		assertThat(ranks.groupBy()).containsEntry(Rank.THIRD, 1L);
	}




}