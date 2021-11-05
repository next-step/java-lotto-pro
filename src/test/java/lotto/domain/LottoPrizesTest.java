package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoPrizesTest {

	@ParameterizedTest
	@CsvSource(delimiter = ',', value = {"5,2,30005000", "5,5,10000", "1,2,2030000000"})
	@DisplayName("여러 순위들이 주어지면, 총 당첨금을 계산한다")
	public void getTotalPrizeTest(int rank1, int rank2, int prize) {
		// given
		LottoRanks ranks = new LottoRanks(Arrays.asList(
			new LottoRank(rank1),
			new LottoRank(rank2)));

		// when
		LottoPrizes prizes = new LottoPrizes(ranks);

		// then
		assertThat(prizes.getTotalPrizeMoney()).isEqualTo(prize);
	}

}
