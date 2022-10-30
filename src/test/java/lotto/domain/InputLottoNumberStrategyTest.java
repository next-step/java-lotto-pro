package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class InputLottoNumberStrategyTest {

	@Test
	void 로또_번호_갯수_6개_제한() {
		assertThatThrownBy(() -> new InputLottoNumberStrategy(Arrays.asList(1, 2, 3, 4)))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
