package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoRankTest {

	static Stream<Arguments> winningNumberAndLottoNumberAndRank() {
		return Stream.of(
			Arguments.of(LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 6)), 1),
			Arguments.of(LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 45)), 2),
			Arguments.of(LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 10)), 3),
			Arguments.of(LottoNumber.of(Arrays.asList(1, 2, 3, 4, 10, 11)), 4),
			Arguments.of(LottoNumber.of(Arrays.asList(1, 2, 3, 10, 11, 12)), 5)
		);
	}

	@ParameterizedTest
	@MethodSource("winningNumberAndLottoNumberAndRank")
	@DisplayName("로또번호와 당첨번호가 주어지면, 순위가 반환되어야 한다")
	public void rankTest(LottoNumber lottoNumber, int rank) {
		// given
		LottoNumber winningNumber = LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 6), 45);

		// when
		LottoRank lottoRank = new LottoRank(winningNumber, lottoNumber);

		// then
		assertThat(lottoRank.getRank()).isEqualTo(rank);
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 6})
	@DisplayName("순위는 1~5위로 이루어져야 한다")
	public void outOfRankTest(int rank) {
		// when, then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new LottoRank(rank));
	}
}
