package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public
class LottoNumberTest {
	@Test
	void lottoNumber() {
		assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
	}

}
