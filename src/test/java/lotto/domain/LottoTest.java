package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class LottoTest {
	@Test
	void 객체_생성() {
		assertThat(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
	}

	@Test
	void 로또_번호_갯수_6개_제한() {
		assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 로또_번호_문자열_반환() {
		assertThat(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)).toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
		assertThat(new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1)).toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
	}

	@Test
	void 로또_번호_포함_여부() {
		assertThat(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)).contains(new LottoNumber(1))).isTrue();
		assertThat(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)).contains(new LottoNumber(7))).isFalse();
	}

	@Test
	void 로또_일치_갯수_확인() {
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		assertThat(lotto.countMatchLottoNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
		assertThat(lotto.countMatchLottoNumber(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)))).isEqualTo(5);
		assertThat(lotto.countMatchLottoNumber(new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)))).isEqualTo(4);
		assertThat(lotto.countMatchLottoNumber(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)))).isEqualTo(3);
		assertThat(lotto.countMatchLottoNumber(new Lotto(Arrays.asList(5, 6, 7, 8, 9, 10)))).isEqualTo(2);
		assertThat(lotto.countMatchLottoNumber(new Lotto(Arrays.asList(6, 7, 8, 9, 10, 11)))).isEqualTo(1);
		assertThat(lotto.countMatchLottoNumber(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)))).isEqualTo(0);
	}
}
