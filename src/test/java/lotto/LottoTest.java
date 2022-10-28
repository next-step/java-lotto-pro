package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class LottoTest {

	@Test
	void 로또의_번호는_6개_이다() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)))
			.withMessage("로또의 번호는 6개 이다.");
	}

	@Test
	void 로또의_번호는_중복될수_없다() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 6, 6)))
			.withMessage("로또의 번호는 6개 이다.");
	}

	@Test
	void 로또의_순서는_정렬되어_있다() {
		assertThat(new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1))).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
	}

	@Test
	void 로또의_숫자_범위는_1에서_45이다() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new Lotto(Arrays.asList(6, 5, 4, 3, 2, 46)))
			.withMessage("로또의 숫자 범위는 1~45 이다.");
	}

}
