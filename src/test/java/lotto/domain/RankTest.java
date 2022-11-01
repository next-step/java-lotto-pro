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
	void getRankByMatchNumberCount(int matchCount, boolean matchingBonus, Rank expectedRank) {
		Rank rank = Rank.of(matchCount, matchingBonus);
		assertThat(rank).isEqualTo(expectedRank);
	}

	private static Stream<Arguments> provideMatchCountAndRank() {
		return Stream.of(
			Arguments.of(6, false, Rank.FIRST),
			Arguments.of(5, true, Rank.SECOND),
			Arguments.of(5, false, Rank.THIRD),
			Arguments.of(4, false, Rank.FOURTH),
			Arguments.of(3, false, Rank.FIFTH),
			Arguments.of(2, false, Rank.LOSE),
			Arguments.of(1, false, Rank.LOSE),
			Arguments.of(0, false, Rank.LOSE)
		);
	}

}