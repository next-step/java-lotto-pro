package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoTest {
	@Test
	void 객체_생성() {
		LottoNumberStrategy lottoNumberStrategy = new TestLottoNumberStrategy();
		assertThat(new Lotto(lottoNumberStrategy)).isEqualTo(new Lotto(lottoNumberStrategy));
	}

	@Test
	void 로또_번호_갯수_6개_제한() {
		LottoNumberStrategy invalidTestLottoNumberStrategy = new InvalidTestLottoNumberStrategy();
		assertThatThrownBy(() -> new Lotto(invalidTestLottoNumberStrategy))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 로또_번호_문자열_반환() {
		assertThat(new Lotto(new TestLottoNumberStrategy()).toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
		assertThat(new Lotto(new OutOfOrderTestLottoNumberStrategy()).toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
	}
}
