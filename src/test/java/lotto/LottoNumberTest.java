package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class LottoNumberTest {

	@Test
	void 로또의_숫자_범위는_1에서_45이다() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new LottoNumber(46))
			.withMessage("로또의 숫자 범위는 1~45 이다.");
	}

}
