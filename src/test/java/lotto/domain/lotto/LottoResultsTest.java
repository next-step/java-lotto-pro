package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import lotto.domain.quantity.Quantity;

class LottoResultsTest {
	List<LottoResult> lottoResults = Arrays.asList(
		LottoResult.from(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), 3, LottoNumber.from(7)),
		LottoResult.from(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), 4, LottoNumber.from(7)),
		LottoResult.from(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), 4, LottoNumber.from(7)),
		LottoResult.from(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), 5, LottoNumber.from(7))
	);

	@Test
	void 객체_생성() {
		Assertions.assertThat(LottoResults.from(lottoResults)).isEqualTo(LottoResults.from(lottoResults));
	}

	@Test
	void 결과_갯수() {
		assertThat(LottoResults.from(lottoResults).quantity()).isEqualTo(Quantity.from(4));
	}

	@Test
	void 일치_갯수로_필터링() {
		assertThat(LottoResults.from(lottoResults).filterByMatchRank(MatchRank.THREE_MATCH).quantity())
			.isEqualTo(Quantity.from(1));
		assertThat(LottoResults.from(lottoResults).filterByMatchRank(MatchRank.FOUR_MATCH).quantity())
			.isEqualTo(Quantity.from(2));
	}
}
