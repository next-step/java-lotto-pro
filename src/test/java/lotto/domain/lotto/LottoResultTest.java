package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoResultTest {
	@Test
	void 객체_생성() {
		Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
		MatchRank matchRank = MatchRank.FIFTH;
		Assertions.assertThat(LottoResult.from(lotto, matchRank)).isEqualTo(LottoResult.from(lotto, matchRank));
	}

	@Test
	void 당첨_등급_체크() {
		Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoResult lottoResult = LottoResult.from(lotto, MatchRank.FIFTH);

		assertThat(lottoResult.hasMatchRank(MatchRank.FIFTH)).isTrue();
		assertThat(lottoResult.hasMatchRank(MatchRank.FOURTH)).isFalse();
	}
}
