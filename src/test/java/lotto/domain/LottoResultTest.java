package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoResultTest {
	@Test
	void 객체_생성() {
		Lotto lotto = Lotto.inputNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
		int matchCount = 3;

		assertThat(LottoResult.from(lotto, matchCount)).isEqualTo(LottoResult.from(lotto, matchCount));
	}

	@Test
	void 일치_갯수_체크() {
		Lotto lotto = Lotto.inputNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
		int matchCount = 3;

		LottoResult lottoResult = LottoResult.from(lotto, matchCount);

		assertThat(lottoResult.hasMatchCount(3)).isTrue();
		assertThat(lottoResult.hasMatchCount(4)).isFalse();
	}
}
