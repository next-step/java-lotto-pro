import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.Lotto;
import model.LottoNumberChoiceRandom;
import model.LottoPurchaseCount;
import model.Lottos;
import model.Rank;
import model.RewardCalculator;

public class LottosTest {
	@Test
	@DisplayName("당첨 번호를 제공하면 해당하는 RewardCalculator 반환")
	void test_calcReward1() {
		Lottos lottos = new Lottos(new LottoNumberChoiceRandom() {
			@Override
			public List<Integer> choose() {
				return Arrays.asList(1, 2, 3, 4, 5, 6);
			}
		}, new LottoPurchaseCount("1000"));
		RewardCalculator rewardCalculator = lottos.calcReward(new Lotto("1, 2, 3, 4, 5, 7"));
		RewardCalculator expectedRewardCalculator = new RewardCalculator();
		expectedRewardCalculator.addCount(Rank.THIRD);

		assertThat(rewardCalculator.sum()).isEqualTo(expectedRewardCalculator.sum());
	}

	@Test
	@DisplayName("원하는 형태의 문자열이 반환되는지 확인")
	void test_toString() {
		Lottos lottos = new Lottos(new LottoNumberChoiceRandom() {
			@Override
			public List<Integer> choose() {
				return Arrays.asList(1, 2, 3, 4, 5, 6);
			}
		}, new LottoPurchaseCount("2000"));

		assertThat(lottos.toString())
			.matches("(\\[\\d+, \\d+, \\d+, \\d+, \\d+, \\d+]\\n)+");
	}
}
