package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
	@Test
	void 로또_생성() {
		assertThat(new Lotto(6, 5, 4, 3, 2, 1)).isNotNull();
	}

	@Test
	void 로또_자릿수부족() {
		assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 로또_자릿수초과() {
		assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 6, 7))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 로또_중복() {
		assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 5))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
