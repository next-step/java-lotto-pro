import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import model.Rank;
import model.RewardCalculator;

public class RewardCalculatorTest {
	@ParameterizedTest
	@DisplayName("아이템을 추가하면 내부 상태 변경")
	@MethodSource("test_addCount1_parameter")
	void test_addCount1(Rank rank) {
		RewardCalculator rewardCalculator = new RewardCalculator();
		rewardCalculator.addCount(rank);

		RewardCalculator rewardCalculator1 = new RewardCalculator();
		rewardCalculator1.addCount(rank);

		assertThat(rewardCalculator).isEqualTo(rewardCalculator1);
	}

	private static Stream<Arguments> test_addCount1_parameter() {
		return Stream.of(
			Arguments.of(Rank.FIRST),
			Arguments.of(Rank.THIRD),
			Arguments.of(Rank.FOURTH),
			Arguments.of(Rank.FIFTH),
			Arguments.of(Rank.NONE)
		);
	}

	@ParameterizedTest
	@DisplayName("아이템을 추가 한 이후 추가한 횟수만큼의 값을 반환")
	@MethodSource("test_getCount1_parameter")
	void test_getCount1(Rank rank, int count) {
		RewardCalculator expected = new RewardCalculator();
		expected.addCount(rank);

		assertThat(expected.getCount(rank)).isEqualTo(count);
	}

	private static Stream<Arguments> test_getCount1_parameter() {
		return Stream.of(
			Arguments.of(Rank.FIRST, 1),
			Arguments.of(Rank.THIRD, 1),
			Arguments.of(Rank.FOURTH, 1),
			Arguments.of(Rank.FIFTH, 1),
			Arguments.of(Rank.NONE, 1)
		);
	}

	@ParameterizedTest
	@DisplayName("추가 된 모든 아이템의 갯수 * 상금을 반환")
	@MethodSource("test_sum1")
	void test_sum1(Rank rank1, Rank rank2) {
		RewardCalculator rewardCalculator = new RewardCalculator();
		rewardCalculator.addCount(rank1);
		rewardCalculator.addCount(rank2);

		assertThat(rewardCalculator.sumReward()).isEqualTo(rank1.getReward() + rank2.getReward());
	}

	private static Stream<Arguments> test_sum1() {
		return Stream.of(
			Arguments.of(Rank.FIRST, Rank.THIRD),
			Arguments.of(Rank.THIRD, Rank.FOURTH),
			Arguments.of(Rank.FOURTH, Rank.FIFTH),
			Arguments.of(Rank.FIFTH, Rank.NONE),
			Arguments.of(Rank.NONE, Rank.FIRST)
		);
	}
}
