package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class LottoResultTest {
	@Test
	void 객체_생성() {
		WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto lotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
		assertThat(new LottoResult(lotto, winningLotto)).isEqualTo(new LottoResult(lotto, winningLotto));
	}

	@Test
	void 당첨_갯수_일치_확인() {
		WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto lotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));

		assertThat(new LottoResult(lotto, winningLotto). hasMatchCount(3)).isTrue();
		assertThat(new LottoResult(lotto, winningLotto).hasMatchCount(6)).isFalse();
	}
}
