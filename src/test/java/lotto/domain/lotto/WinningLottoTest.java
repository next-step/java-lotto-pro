package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WinningLottoTest {

	@Test
	void 객체_생성() {
		assertThat(WinningLotto.from("1,2,3,4,5,6", "7"))
			.isEqualTo(WinningLotto.from("1,2,3,4,5,6", "7"));
	}

	@Test
	void 숫자_이외의_문자_입력() {
		assertThatThrownBy(() -> WinningLotto.from("1,2,3,4,5,6", "a"))
			.isInstanceOf(NumberFormatException.class);
		assertThatThrownBy(() -> WinningLotto.from("1,2,3,4,5,a", "7"))
			.isInstanceOf(NumberFormatException.class);
	}

	@Test
	void 보너스번호_당첨번호와_일치하는_번호존재_IllegalStateException() {
		assertThatThrownBy(() -> WinningLotto.from("1,2,3,4,5,6", "1"))
			.isInstanceOf(IllegalStateException.class);
	}
}
