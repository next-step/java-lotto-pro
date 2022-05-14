package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AnswerTest {
	@Test
	void 당첨번호_생성() {
		assertThat(new Answer("6, 5, 4, 3, 2, 1")).isNotNull();
	}

	@Test
	void 당첨번호_자릿수부족() {
		assertThatThrownBy(() -> new Answer("1, 2, 3, 4, 5"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 당첨번호_자릿수초과() {
		assertThatThrownBy(() -> new Answer("1, 2, 3, 4, 5, 6, 7"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 당첨번호_중복() {
		assertThatThrownBy(() -> new Answer("1, 2, 3, 4, 5, 5"))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
