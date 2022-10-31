package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PriceTest {
	@Test
	void 객체_생성() {
		assertThat(Price.from(5000L)).isEqualTo(Price.from(5000L));
	}

	@Test
	void 객체_생성_문자열() {
		assertThat(Price.from("5000")).isEqualTo(Price.from("5000"));
	}

	@Test
	void 객체_생성_문자열_실패() {
		assertThatThrownBy(() -> Price.from("실패"))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
