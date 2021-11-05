package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoRankTest {

	static List<Arguments> winningNumberAndLottoNumberAndRank() {
		return Arrays.asList(
			arguments(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), 1),
			arguments(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 10), 2),
			arguments(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 9, 10), 3),
			arguments(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 8, 9, 10), 4)
		);
	}

	@ParameterizedTest
	@MethodSource("winningNumberAndLottoNumberAndRank")
	@DisplayName("로또번호가 주어지면, 순위가 반환되어야 한다")
	public void rankTest(List<Integer> winNumberList, List<Integer> numberList, int rank) {
		LottoNumber winningNumber = LottoNumber.of(winNumberList);
		LottoNumber number1st = LottoNumber.of(numberList);

		LottoRank lottoRank = new LottoRank(winningNumber, number1st);

		assertThat(lottoRank.getRank()).isEqualTo(rank);
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 5})
	@DisplayName("순위는 1~4위로 이루어져야 한다")
	public void outOfRankTest(int rank) {
		// when, then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new LottoRank(rank));
	}
}
