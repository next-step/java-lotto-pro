package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("순위 테스트")
class RankTest {

	@Test
	@DisplayName("순위 생성")
	void createRank() {
		Rank rank = Rank.FIRST;
		assertThat(rank).isInstanceOf(Rank.class);
	}

	@ParameterizedTest
	@MethodSource("provideMatchCountAndRank")
	@DisplayName("숫자 일치 개수에 따른 순위 반환")
	void getRankByMatchNumberCount(int matchCount, Rank expectedRank) {
		Rank rank = Rank.of(matchCount);
		assertThat(rank).isEqualTo(expectedRank);
	}

	private static Stream<Arguments> provideMatchCountAndRank() {
		return Stream.of(
			Arguments.of(6, Rank.FIRST),
			Arguments.of(5, Rank.SECOND),
			Arguments.of(4, Rank.THIRD),
			Arguments.of(3, Rank.FOURTH),
			Arguments.of(2, Rank.LOSE),
			Arguments.of(1, Rank.LOSE),
			Arguments.of(0, Rank.LOSE)
		);
	}

}