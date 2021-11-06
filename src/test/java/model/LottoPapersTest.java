package model;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import model.common.LottoNumber;
import model.common.LottoNumbers;
import model.common.Score;

@DisplayName("로또들")
class LottoPapersTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> LottoPapers.from(Collections.singleton(mock(LottoPaper.class))));
	}

	@Test
	@DisplayName("로또가 비어있는 상태에서 객체화하면 IllegalArgumentException")
	void instance_nullLottoPrice_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> LottoPapers.from(null))
			.withMessage("lotto collection must not be null");
	}

	@ParameterizedTest(name = "{displayName}[{index}] rank({0}) count is {1}")
	@DisplayName("당첨된 결과")
	@CsvSource({"FIRST,1", "SECOND,1", "THIRD,0", "FOURTH,1", "FIFTH,0", "NONE,1"})
	void score(LottoRank rank, int expected) {
		//given
		LottoPapers papers = LottoPapers.from(
			Arrays.asList(
				LottoPaper.from(lottoNumbers(9, 10, 11, 12, 13, 14)),
				LottoPaper.from(lottoNumbers(1, 2, 3, 4, 5, 6)),
				LottoPaper.from(lottoNumbers(1, 2, 3, 4, 8, 9)),
				LottoPaper.from(lottoNumbers(1, 2, 3, 4, 5, 10))
			));

		//when
		Score score = papers.score(WinnerLotto.from(lottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber.from(10)));

		//then
		assertThat(score.count(rank))
			.isEqualTo(expected);
	}

	private LottoNumbers lottoNumbers(int... numbers) {
		Set<LottoNumber> numbersSet = new HashSet<>();
		for (int number : numbers) {
			numbersSet.add(LottoNumber.from(number));
		}
		return LottoNumbers.from(numbersSet);
	}
}
