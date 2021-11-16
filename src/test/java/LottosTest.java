import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import exception.OutOfRangeException;
import model.Lotto;
import model.LottoNumber;
import model.LottoNumberChoiceRandom;
import model.LottoPurchaseCount;
import model.Lottos;
import model.Rank;
import model.RewardCalculator;

public class LottosTest {
	@Test
	@DisplayName("로또 숫자가 6개가 주어지지 않으면 예외")
	void test_constructor1() {
		assertThatThrownBy(() -> new Lottos(
			new LottoNumberChoiceRandom() {
				@Override
				public List<Integer> choose() {
					return Arrays.asList(1, 2);
				}
			}, new LottoPurchaseCount(1000)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Lotto.MESSAGE_NOT_ALLOW_LENGTH);
	}

	@Test
	@DisplayName("로또 숫자에 중복된 값이 포함되어있으면 예외")
	void test_constructor2() {
		assertThatThrownBy(() ->
			new Lottos(
				new LottoNumberChoiceRandom() {
					@Override
					public List<Integer> choose() {
						return Arrays.asList(1, 1, 3, 4, 5, 7);
					}
				}, new LottoPurchaseCount(1000)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Lotto.MESSAGE_NOT_ALLOW_DUPLICATION);
	}

	@Test
	@DisplayName("로또 숫자가 6개가 포함되면서 겹치는 값이 없으면 성공")
	void test_constructor3() {
		assertThatNoException()
			.isThrownBy(() -> {
				new Lottos(
					new LottoNumberChoiceRandom() {
						@Override
						public List<Integer> choose() {
							return Arrays.asList(1, 2, 3, 4, 5, 6);
						}
					}, new LottoPurchaseCount(10000));
			});
	}

	@Test
	@DisplayName("0원을 이용해 로또를 구매하려하면 예외")
	void test_constructor4() {
		assertThatThrownBy(() -> {
			new Lottos(
				new LottoNumberChoiceRandom() {
					@Override
					public List<Integer> choose() {
						return Arrays.asList(1, 2, 3, 4, 5, 6);
					}
				}, new LottoPurchaseCount(0));
		}).isInstanceOf(OutOfRangeException.class)
			.hasMessage(LottoPurchaseCount.MESSAGE_COUNT_MUST_BE_LARGER_THAN_ZERO);
	}

	@ParameterizedTest
	@DisplayName("당첨 번호를 제공하면 해당하는 RewardCalculator 반환")
	@MethodSource("test_calcReward1_parameter")
	void test_calcReward1(List<Integer> userLotto, List<Integer> winningLotto, Rank expectedRank, int bonusNumber) {
		Lottos lottos = new Lottos(
			new LottoNumberChoiceRandom() {
				@Override
				public List<Integer> choose() {
					return userLotto;
				}
			}, new LottoPurchaseCount(1));
		RewardCalculator rewardCalculator = lottos.calcReward(new Lotto(winningLotto), new LottoNumber(bonusNumber));
		RewardCalculator expectedRewardCalculator = new RewardCalculator();
		expectedRewardCalculator.addCount(expectedRank);

		assertThat(rewardCalculator).isEqualTo(expectedRewardCalculator);
	}

	private static Stream<Arguments> test_calcReward1_parameter() {
		int bonusNumberHit = 6;
		int bonusNumberNotHit = 45;

		return Stream.of(
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), Rank.FIRST, bonusNumberNotHit),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 7), Rank.SECOND, bonusNumberHit),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 7), Rank.THIRD, bonusNumberNotHit),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 7, 8), Rank.FOURTH, bonusNumberHit),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 7, 8, 9), Rank.FIFTH, bonusNumberHit),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 7, 8, 9, 10), Rank.NONE, bonusNumberHit),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 7, 8, 9, 10, 11), Rank.NONE, bonusNumberHit),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(7, 8, 9, 10, 11, 12), Rank.NONE, bonusNumberHit)
		);
	}

	@Test
	@DisplayName("원하는 형태의 문자열이 반환되는지 확인")
	void test_toString() {
		Lottos lottos = new Lottos(
			new LottoNumberChoiceRandom() {
				@Override
				public List<Integer> choose() {
					return Arrays.asList(1, 2, 3, 4, 5, 6);
				}
			}, new LottoPurchaseCount(2));

		assertThat(lottos.toString())
			.matches("(\\[\\d+, \\d+, \\d+, \\d+, \\d+, \\d+]\\n)+");
	}
}
