package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoRanksTest {

	public static Stream<Arguments> givenGetTotalPrizeTest() {
		return Stream.of(
			Arguments.of(Arrays.asList(Rank.SECOND, Rank.FIFTH), 30005000),
			Arguments.of(Arrays.asList(Rank.FIFTH, Rank.FIFTH), 10000),
			Arguments.of(Arrays.asList(Rank.FIRST, Rank.SECOND), 2030000000)
		);
	}

	@Test
	@DisplayName("로또 순위들이 주어지면, 각 순위 별 갯수를 반환한다")
	public void getRankCountTest() {
		// given
		List<Rank> rankList = Arrays.asList(
			Rank.FIFTH, Rank.FOURTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);

		// when
		LottoRanks ranks = LottoRanks.of(rankList);

		// then
		assertThat(ranks.getFirstCnt()).isEqualTo(1);
		assertThat(ranks.getSecondCnt()).isEqualTo(1);
		assertThat(ranks.getThirdCnt()).isEqualTo(1);
		assertThat(ranks.getFourthCnt()).isEqualTo(2);
		assertThat(ranks.getFifthCnt()).isEqualTo(1);
	}

	@ParameterizedTest
	@MethodSource("givenGetTotalPrizeTest")
	@DisplayName("로또 순위들에 따라, 총 당첨금을 반환한다")
	public void getTotalPrizeTest(List<Rank> rankList, int expected) {
		// given
		LottoRanks ranks = LottoRanks.of(rankList);

		// when
		int prize = ranks.getTotalPrizeMoney();

		// then
		assertThat(prize).isEqualTo(expected);

	}

}
