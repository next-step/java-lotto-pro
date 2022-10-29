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
}
