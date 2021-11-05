package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoNumberTest {
	@Test
	public void init() {
		LottoNumber lottoNumber = new LottoNumber(1);
		assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
	}

	@Test
	public void 로또_번호_1_에서_45_숫자_검증() {
		assertThatThrownBy(() -> new LottoNumber(80))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
