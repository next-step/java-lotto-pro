package lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import lotto.domain.lotto.Lotto;

class LottoMessageTest {
	@Test
	void 로또_번호_문자열_반환() {
		assertThat(new LottoMessage(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6))).toString()).isEqualTo(
			"[1, 2, 3, 4, 5, 6]");
		assertThat(new LottoMessage(Lotto.from(Arrays.asList(6, 5, 4, 3, 2, 1))).toString()).isEqualTo(
			"[1, 2, 3, 4, 5, 6]");
	}
}
