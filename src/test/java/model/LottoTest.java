package model;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class LottoTest {
	private static final int ENOUGH_TEST_COUNT = 1000;

	@Test
	void 생성한_숫자는_6개() {
		Lotto lotto = Lotto.create();

		assertThat(lotto.getNumbers().size()).isEqualTo(6);
	}

	@Test
	@DisplayName("당첨번호가(1,2,3,4,5,6) 일 때 구매한 로또가 (1,3,5,7,9,44)이면 일치하는 숫자는 3개")
	void 당첨_번호와_일부가_일치하는_경우() {
		Lotto winningNumber = new Lotto(Lists.newArrayList(1, 2, 3, 4, 5, 6));
		Lotto lotto = new Lotto(Lists.newArrayList(1, 3, 5, 7, 9, 44));

		Count result = winningNumber.matchCount(lotto);

		assertThat(result).isEqualTo(Count.from(3));
	}

	@Test
	@DisplayName("모든 번호가 일치하는 경우 6개")
	void 당첨인_경우() {
		Lotto winningNumber = new Lotto(Lists.newArrayList(1, 2, 3, 4, 5, 6));
		Lotto lotto = new Lotto(Lists.newArrayList(1, 2, 3, 4, 5, 6));

		Count result = winningNumber.matchCount(lotto);

		assertThat(result).isEqualTo(Count.from(6));
	}

	@Test
	@DisplayName("일치하는게 하나도 없는 경우 0개")
	void 일치하는_숫자가_없는_경우() {
		Lotto winningNumber = new Lotto(Lists.newArrayList(1, 2, 3, 4, 5, 6));
		Lotto lotto = new Lotto(Lists.newArrayList(7, 8, 9, 10, 11, 12));

		Count result = winningNumber.matchCount(lotto);

		assertThat(result).isEqualTo(Count.from(0));
	}

	@Test
	void 보너스볼_일치() {
		Lotto winningNumber = new Lotto(Lists.newArrayList(1, 2, 3, 4, 5, 6));
		BonusBall bonusBall = BonusBall.from(6);

		boolean result = winningNumber.isMatchBonusBall(bonusBall);

		assertThat(result).isTrue();
	}

	@Test
	void 보너스볼_불일치() {
		Lotto winningNumber = new Lotto(Lists.newArrayList(1, 2, 3, 4, 5, 6));
		BonusBall bonusBall = BonusBall.from(7);

		boolean result = winningNumber.isMatchBonusBall(bonusBall);

		assertThat(result).isFalse();
	}

	@RepeatedTest(value = ENOUGH_TEST_COUNT, name = "중복되는 수는 없어야 한다 {currentRepetition} / {totalRepetitions}")
	void 중복되는_숫자는_없어야_한다() {
		Lotto lotto = Lotto.create();
		Set<Integer> numberSet = Sets.newHashSet(lotto.getNumbers());

		assertThat(numberSet.size()).isEqualTo(6);
	}
}
