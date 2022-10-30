package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class LottoResultsTest {

	@Test
	void 객체_생성() {
		List<LottoResult> lottoResults = Arrays.asList(
			LottoResult.from(Lotto.random(), 3),
			LottoResult.from(Lotto.random(), 4),
			LottoResult.from(Lotto.random(), 5)
		);
		assertThat(LottoResults.from(lottoResults)).isEqualTo(LottoResults.from(lottoResults));
	}

	@Test
	void 일치_갯수별_로또_결과_컬랙션_생성() {
		LottoResults lottoResults = LottoResults.from(
			Arrays.asList(
				LottoResult.from(Lotto.random(), 3),
				LottoResult.from(Lotto.random(), 4),
				LottoResult.from(Lotto.random(), 5)
			)
		);
		assertThat(lottoResults.toLottoResultMatchCounts(3)).isNotNull();
		assertThat(lottoResults.toLottoResultMatchCounts(3).getQuantity()).isEqualTo(1);
	}

}
