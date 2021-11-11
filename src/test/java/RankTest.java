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
			Arguments.of(Rank.THIRD, 1500000),
			Arguments.of(Rank.FOURTH, 50000),
			Arguments.of(Rank.FIFTH, 5000),
			Arguments.of(Rank.NONE, 0)
		);
	}
}
