package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottosTest {
	@Test
	void 객체_생성_숫자가_아닌_문자열_IllegalArgumentException() {
		assertThatThrownBy(() -> new Lottos("숫자아님"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 객체_생성_로또_객체_생성() {
		assertThat(new Lottos(3000).getQuantity()).isEqualTo(3);
	}
}
