package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class LottoNumberTest {

	@Test
	void 숫자형_문자로_생성() {
		assertThat(LottoNumber.of("1", "2", "3", "4", "5", "6"))
			.isEqualTo(LottoNumber.of(1, 2, 3, 4, 5, 6));
	}

	@Test
	void 로또의_숫자_범위는_1에서_45이다() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> LottoNumber.of(46))
			.withMessage("로또의 숫자 범위는 1~45 이다.");
	}

	@Test
	void 로또_번호_목록을_생성한다() {
		assertThat(LottoNumber.of(1, 2, 3, 4, 5, 6)).isEqualTo(
			Arrays.asList(
				LottoNumber.of(1),
				LottoNumber.of(2),
				LottoNumber.of(3),
				LottoNumber.of(4),
				LottoNumber.of(5),
				LottoNumber.of(6)
			)
		);
	}

	@Test
	void 로또_번호를_생성한다() {
		assertThat(LottoNumber.of(1)).isEqualTo(LottoNumber.of(1));
	}
}
