package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AmountTest {
	@Test
	void 객체_생성() {
		assertThat(Amount.from(5000L)).isEqualTo(Amount.from(5000L));
	}

	@Test
	void 객체_생성_문자열() {
		assertThat(Amount.from("5000")).isEqualTo(Amount.from("5000"));
	}

	@Test
	void 객체_생성_문자열_실패() {
		assertThatThrownBy(() -> Amount.from("실패"))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
