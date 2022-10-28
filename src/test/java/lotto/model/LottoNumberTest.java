package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import lotto.model.LottoNumber;

class LottoNumberTest {

	@Test
	void 로또의_숫자_범위는_1에서_45이다() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new LottoNumber(46))
			.withMessage("로또의 숫자 범위는 1~45 이다.");
	}

	@Test
	void 로또_번호_목록을_생성한다() {
		assertThat(LottoNumber.of(1, 2, 3, 4, 5, 6)).isEqualTo(
			Arrays.asList(
				new LottoNumber(1),
				new LottoNumber(2),
				new LottoNumber(3),
				new LottoNumber(4),
				new LottoNumber(5),
				new LottoNumber(6)
			)
		);
	}

	@Test
	void 로또_번호를_생성한다() {
		assertThat(LottoNumber.of(1)).isEqualTo(new LottoNumber(1));
	}
}
