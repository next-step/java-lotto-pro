package lotto;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoTest {

	@Test
	void 로또의_번호는_6개_이다() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new Lotto(LottoNumber.of(1, 2, 3, 4, 5)))
			.withMessage("로또의 번호는 6개 이다.");
	}

	@Test
	void 로또의_번호는_중복될수_없다() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new Lotto(LottoNumber.of(1, 2, 3, 4, 6, 6)))
			.withMessage("로또의 번호는 6개 이다.");
	}

	@Test
	void 로또의_순서는_정렬되어_있다() {
		assertThat(new Lotto(LottoNumber.of(6, 5, 4, 3, 2, 1))).isEqualTo(new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6)));
	}

	@Test
	void 로또의_번호와_승리번호의_일치_갯수_확인() {
		Lotto lotto = new Lotto(LottoNumber.of(6, 5, 4, 3, 2, 1));
		Assertions.assertThat(lotto.match(new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 7)))).isEqualTo(5);
	}

}
