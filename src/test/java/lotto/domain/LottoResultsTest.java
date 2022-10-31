package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class LottoResultsTest {
	List<LottoResult> lottoResults = Arrays.asList(
		LottoResult.from(Lotto.random(), MatchCount.from(3)),
		LottoResult.from(Lotto.random(), MatchCount.from(4)),
		LottoResult.from(Lotto.random(), MatchCount.from(5))
	);;

	@Test
	void 객체_생성() {
		assertThat(LottoResults.from(lottoResults)).isEqualTo(LottoResults.from(lottoResults));
	}

	@Test
	void 일치_갯수별_로또_결과_컬랙션_생성() {
		assertThat(LottoResults.from(lottoResults).toLottoResultMatchCounts(MatchCount.from(3))).isNotNull();
	}

	@Test
	void 결과_갯수() {
		assertThat(LottoResults.from(lottoResults).quantity()).isEqualTo(3);
	}

	@Test
	void 수익률() {
		assertThat(LottoResults.from(lottoResults).yield()).isEqualTo(518333.33f);
	}
}
