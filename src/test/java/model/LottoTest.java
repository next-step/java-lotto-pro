package model;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("로또")
class LottoTest {

	private static Stream<Arguments> instance_mismatchSixSize_thrownIllegalArgumentException() {
		return Stream.of(
			Arguments.of(new int[] {1}),
			Arguments.of(new int[] {1, 2, 3, 4}),
			Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7, 8})
		);
	}

	private static Stream<Arguments> rank() {
		return Stream.of(
			Arguments.of(new int[] {10, 11, 12, 13, 14, 15}, LottoRank.NONE),
			Arguments.of(new int[] {1, 2, 3, 11, 12, 13}, LottoRank.FOURTH),
			Arguments.of(new int[] {3, 4, 5, 6, 7, 8}, LottoRank.THIRD),
			Arguments.of(new int[] {3, 2, 1, 4, 5, 10}, LottoRank.SECOND),
			Arguments.of(new int[] {6, 5, 4, 3, 2, 1}, LottoRank.FIRST)
		);
	}

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> Lotto.from(lottoNumbers(1, 2, 3, 4, 5, 6)));
	}

	@Test
	@DisplayName("숫자 없이 객체화하면 IllegalArgumentException")
	void instance_nullNumbers_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Lotto.from(null))
			.withMessage("'numberCollection' must not be empty");
	}

	@ParameterizedTest(name = "{displayName}[{index}] when the winning number is {0}, [1,2,3,4,5,6] rank is {1}")
	@MethodSource
	@DisplayName("순위 매칭")
	void rank(int[] winningNumber, LottoRank expected) {
		//when
		LottoRank rank = Lotto.from(lottoNumbers(1, 2, 3, 4, 5, 6))
			.rank(Lotto.from(lottoNumbers(winningNumber)));

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
