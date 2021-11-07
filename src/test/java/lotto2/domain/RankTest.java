package lotto2.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RankTest {

	public static Stream<Arguments> givenOfTest() {
		return Stream.of(
			Arguments.of(6, true, Rank.FIRST),
			Arguments.of(6, false, Rank.FIRST),
			Arguments.of(5, true, Rank.SECOND),
			Arguments.of(5, false, Rank.THIRD),
			Arguments.of(4, false, Rank.FOURTH),
			Arguments.of(4, true, Rank.FOURTH),
			Arguments.of(3, true, Rank.FIFTH),
			Arguments.of(3, false, Rank.FIFTH),
			Arguments.of(2, true, Rank.MISS),
			Arguments.of(2, false, Rank.MISS),
			Arguments.of(1, true, Rank.MISS),
			Arguments.of(1, false, Rank.MISS),
			Arguments.of(0, true, Rank.MISS),
			Arguments.of(0, false, Rank.MISS)
		);
	}

	@ParameterizedTest
	@MethodSource("givenOfTest")
	@DisplayName("번호 일치갯수와 보너스번호 일치여부로 순위를 생성한다")
	public void ofTest(int matchCntNumber, boolean isMatchBonus, Rank expected) {
		// given
		PositiveNumber matchCount = PositiveNumber.of(matchCntNumber);

		// when
		Rank rank = Rank.valueOf(matchCount, isMatchBonus);

		// then
		assertThat(rank).isEqualTo(expected);
	}

	@Test
	@DisplayName("일치개수는 0~6사이여야 한다")
	public void ofTest() {
		// given, when, then
		assertThatThrownBy(() -> Rank.valueOf(PositiveNumber.of(7), true))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("당첨 순위에 해당하는 일치갯수를 반환해야 한다")
	public void getMatchCntTest() {
		// given
		int expected = 6;
		Rank rank = Rank.FIRST;

		// when
		int matchCnt = rank.getMatchCnt();

		// then
		assertThat(matchCnt).isEqualTo(expected);
	}

	@Test
	@DisplayName("당첨 순위에 해당하는 금액이 반환되어야 한다")
	public void getPrizeTest() {
		// given
		int expectedPrize = 2_000_000_000;
		Rank rank = Rank.FIRST;

		// when
		int prize = rank.getPrize();

		// then
		assertThat(prize).isEqualTo(expectedPrize);
	}

}
