package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class LottoResultsTest {
	List<LottoResult> lottoResults = Arrays.asList(
		LottoResult.from(Lotto.random(), MatchCount.from(3)),
		LottoResult.from(Lotto.random(), MatchCount.from(4)),
		LottoResult.from(Lotto.random(), MatchCount.from(4)),
		LottoResult.from(Lotto.random(), MatchCount.from(5))
	);

	@Test
	void 객체_생성() {
		assertThat(LottoResults.from(lottoResults)).isEqualTo(LottoResults.from(lottoResults));
	}

	@Test
	void 결과_갯수() {
		assertThat(LottoResults.from(lottoResults).quantity()).isEqualTo(Quantity.from(4));
	}

	@Test
	void 일치_갯수로_필터링() {
		assertThat(LottoResults.from(lottoResults).filterByMatchCount(MatchCount.from(3)).quantity())
			.isEqualTo(Quantity.from(1));
		assertThat(LottoResults.from(lottoResults).filterByMatchCount(MatchCount.from(4)).quantity())
			.isEqualTo(Quantity.from(2));
	}
}
