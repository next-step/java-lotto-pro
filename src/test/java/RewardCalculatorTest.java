import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.Rank;
import model.RewardCalculator;

public class RewardCalculatorTest {
	@Test
	@DisplayName("아이템을 추가하면 내부 상태 변경")
	void test_addCount1() {
		RewardCalculator rewardCalculator = new RewardCalculator();
		rewardCalculator.addCount(Rank.FIRST);

		RewardCalculator rewardCalculator1 = new RewardCalculator();
		rewardCalculator1.addCount(Rank.FIRST);

		assertThat(rewardCalculator).isEqualTo(rewardCalculator1);
	}

	@Test
	@DisplayName("아이템을 추가 한 이후 추가한 횟수만큼의 값을 반환")
	void test_getCount1() {
		RewardCalculator rewardCalculator = new RewardCalculator();
		rewardCalculator.addCount(Rank.FIRST);

		assertThat(rewardCalculator.getCount(Rank.FIRST)).isEqualTo(1);
	}

	@Test
	@DisplayName("추가 된 모든 아이템의 갯수 * 상금을 반환")
	void test_sum1() {
		RewardCalculator rewardCalculator = new RewardCalculator();
		rewardCalculator.addCount(Rank.FIFTH);
		rewardCalculator.addCount(Rank.FOURTH);

		assertThat(rewardCalculator.sum()).isEqualTo(55000);
	}
}
