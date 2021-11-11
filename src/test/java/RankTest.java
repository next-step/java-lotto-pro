import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import model.Rank;

public class RankTest {
	@ParameterizedTest
	@DisplayName("등급과 상금이 매핑되어있는지 확인")
	@MethodSource("test_getReward1_parameter")
	void test_getReward1(Rank rank, int reward) {
		assertThat(rank.getReward()).isEqualTo(reward);
	}

	static Stream<Arguments> test_getReward1_parameter() {
		return Stream.of(
			Arguments.of(Rank.FIRST, 2000000000),
			Arguments.of(Rank.SECOND, 30000000),
			Arguments.of(Rank.THIRD, 1500000),
			Arguments.of(Rank.FOURTH, 50000),
			Arguments.of(Rank.FIFTH, 5000),
			Arguments.of(Rank.NONE, 0)
		);
	}

	@ParameterizedTest
	@DisplayName("matchingCount에 따라서 Rank를 반환")
	@MethodSource("test_getByMatchingCount1_parameter")
	void test_getByMatchingCount1(int matchingCount, Rank expectedRank, boolean isMatchBonusNumber) {
		assertThat(expectedRank).isEqualTo(Rank.mapByMatchingCountAndBonusFlag(matchingCount, isMatchBonusNumber));
	}

	static Stream<Arguments> test_getByMatchingCount1_parameter() {
		return Stream.of(
			Arguments.of(6, Rank.FIRST, true),
			Arguments.of(5, Rank.SECOND, true),
			Arguments.of(5, Rank.THIRD, false),
			Arguments.of(4, Rank.FOURTH, true),
			Arguments.of(3, Rank.FIFTH, true),
			Arguments.of(2, Rank.NONE, true),
			Arguments.of(1, Rank.NONE, true),
			Arguments.of(0, Rank.NONE, true)
		);
	}
}
