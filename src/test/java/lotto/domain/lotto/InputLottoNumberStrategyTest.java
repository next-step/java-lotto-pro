package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class InputLottoNumberStrategyTest {
	@Test
	void 로또_번호_6개_입력() {
		assertThat(new InputLottoNumberStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)).pickNumbers())
			.isEqualTo(new HashSet<>(
				Arrays.asList(
					LottoNumber.from(1),
					LottoNumber.from(2),
					LottoNumber.from(3),
					LottoNumber.from(4),
					LottoNumber.from(5),
					LottoNumber.from(6)
				))
			);
	}

	@Test
	void 로또_번호_갯수_6개_제한() {
		assertThatThrownBy(() -> new InputLottoNumberStrategy(Arrays.asList(1, 2, 3, 4)))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
