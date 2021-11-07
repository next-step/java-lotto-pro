package model;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import model.common.LottoNumber;
import model.common.LottoNumbers;

@DisplayName("로또 종이")
class LottoPaperTest {

	private static Stream<Arguments> rank() {
		return Stream.of(
			Arguments.of(new int[] {10, 11, 12, 13, 14, 15}, LottoRank.NONE),
			Arguments.of(new int[] {3, 4, 5, 13, 14, 15}, LottoRank.FIFTH),
			Arguments.of(new int[] {1, 2, 3, 11, 4, 13}, LottoRank.FOURTH),
			Arguments.of(new int[] {3, 4, 5, 6, 1, 8}, LottoRank.THIRD),
			Arguments.of(new int[] {3, 2, 1, 4, 5, 10}, LottoRank.SECOND),
			Arguments.of(new int[] {6, 5, 4, 3, 2, 1}, LottoRank.FIRST)
		);
	}

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> LottoPaper.auto(LottoNumbers.from(lottoNumbers(1, 2, 3, 4, 5, 6))));
	}

	@Test
	@DisplayName("숫자 빈 상태로 객체화하면 IllegalArgumentException")
	void instance_nullNumbers_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> LottoPaper.auto(null))
			.withMessage("'lottoNumbers' must not be null");
	}

	@ParameterizedTest(name = "{displayName}[{index}] when the winning number is [1,2,3,4,5,6], {0} rank is {1}")
	@MethodSource
	@DisplayName("순위 매칭")
	void rank(int[] winningNumber, LottoRank expected) {
		//when
		LottoRank rank = LottoPaper.auto(LottoNumbers.from(lottoNumbers(winningNumber)))
			.rank(WinnerLotto.from(LottoNumbers.from(lottoNumbers(1, 2, 3, 4, 5, 6)), LottoNumber.from(10)));

		//then
		assertThat(rank)
			.isEqualTo(expected);
	}

	private Set<LottoNumber> lottoNumbers(int... numbers) {
		Set<LottoNumber> numbersSet = new HashSet<>();
		for (int number : numbers) {
			numbersSet.add(LottoNumber.from(number));
		}
		return numbersSet;
	}

}
