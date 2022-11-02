package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoResultTest {
	@Test
	void 객체_생성() {
		Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoNumber bonusNumber = LottoNumber.from(7);
		Assertions.assertThat(LottoResult.from(lotto, 3, bonusNumber)).isEqualTo(LottoResult.from(lotto, 3, bonusNumber));
	}

	@Test
	void 일치_횟수_0미만_IllegalArgumentException() {
		assertThatThrownBy(() -> LottoResult.from(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), -1, LottoNumber.from(7)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 당첨_등급_체크() {
		Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
		MatchRank matchRank = MatchRank.THREE_MATCH;

		LottoResult lottoResult = LottoResult.from(lotto, 3, LottoNumber.from(7));

		assertThat(lottoResult.hasMatchRank(matchRank)).isTrue();
		assertThat(lottoResult.hasMatchRank(MatchRank.FOUR_MATCH)).isFalse();
	}
}
