package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class RankTest {

	public static Stream<Arguments> givenGetMatchAndPrizeTest() {
		return Stream.of(
			Arguments.of(2_000_000_000, 6, Rank.FIRST),
			Arguments.of(30_000_000, 5, Rank.SECOND),
			Arguments.of(1_500_000, 5, Rank.THIRD),
			Arguments.of(50_000, 4, Rank.FOURTH),
			Arguments.of(5_000, 3, Rank.FIFTH),
			Arguments.of(0, 0, Rank.MISS)
		);
	}

	public static Stream<Arguments> givenValueOfTest() {
		return Stream.of(
			Arguments.of(6, false, Rank.FIRST),
			Arguments.of(6, true, Rank.FIRST),
			Arguments.of(5, true, Rank.SECOND),
			Arguments.of(5, false, Rank.THIRD),
			Arguments.of(4, true, Rank.FOURTH),
			Arguments.of(4, false, Rank.FOURTH),
			Arguments.of(3, true, Rank.FIFTH),
			Arguments.of(3, false, Rank.FIFTH),
			Arguments.of(0, true, Rank.MISS),
			Arguments.of(0, false, Rank.MISS)
		);
	}

	static Stream<Arguments> givenGetMatchRankTest() {
		return Stream.of(
			Arguments.of(LottoNumber.of(
				Arrays.asList(1, 2, 3, 4, 5, 6)), Rank.FIRST),
			Arguments.of(LottoNumber.of(
				Arrays.asList(1, 2, 3, 4, 5, 45)), Rank.SECOND),
			Arguments.of(LottoNumber.of(
				Arrays.asList(1, 2, 3, 4, 5, 10)), Rank.THIRD),
			Arguments.of(LottoNumber.of(
				Arrays.asList(1, 2, 3, 4, 10, 11)), Rank.FOURTH),
			Arguments.of(LottoNumber.of(
				Arrays.asList(1, 2, 3, 10, 11, 12)), Rank.FIFTH),
			Arguments.of(LottoNumber.of(
				Arrays.asList(1, 2, 10, 11, 12, 13)), Rank.MISS)
		);
	}

	@ParameterizedTest
	@MethodSource("givenValueOfTest")
	@DisplayName("일치갯수와 보너스번호 일치여부에 맞는 당첨순위를 반환해야 한다")
	public void valueOfTest(int matchCnt, boolean isMatchBonus, Rank expected) {
		// when
		Rank rank = Rank.valueOf(matchCnt, isMatchBonus);

		// then
		assertThat(rank).isEqualTo(expected);

	}

	@ParameterizedTest
	@CsvSource(value = {"7, true", "-1,false"}, delimiter = ',')
	@DisplayName("잘못된 일치갯수가 주어지면, Exception이 발생해야 한다")
	public void valueOfTest(int matchCnt, boolean isMatchBonus) {
		// when, then
		assertThatThrownBy(() -> Rank.valueOf(matchCnt, isMatchBonus))
			.isInstanceOf(IllegalArgumentException.class);

	}

	@ParameterizedTest
	@MethodSource("givenGetMatchAndPrizeTest")
	@DisplayName("당첨 순위에 해당하는 일치갯수를 반환해야 한다")
	public void getMatchCntTest(int expectedPrize, int expected, Rank rank) {
		// when
		int matchCnt = rank.getMatchCnt();

		// then
		assertThat(matchCnt).isEqualTo(expected);
	}

	@ParameterizedTest
	@MethodSource("givenGetMatchAndPrizeTest")
	@DisplayName("당첨 순위에 해당하는 금액이 반환되어야 한다")
	public void getPrizeTest(int expectedPrize, int matchCnt, Rank rank) {
		// when
		int prize = rank.getPrize();

		// then
		assertThat(prize).isEqualTo(expectedPrize);
	}

	@ParameterizedTest
	@MethodSource("givenGetMatchRankTest")
	@DisplayName("로또번호와 당첨번호가 주어지면, 순위가 반환되어야 한다")
	public void getMatchRankTest(LottoNumber lottoNumber, Rank expected) {
		// given
		LottoNumber winningNumber = LottoNumber.ofWinning(
			Arrays.asList(1, 2, 3, 4, 5, 6), 45);

		// when
		Rank lottoRank = Rank.getMatchRank(winningNumber, lottoNumber);

		// then
		assertThat(lottoRank).isEqualTo(expected);
	}

}
