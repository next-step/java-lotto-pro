import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.LottoNumber;

public class LottoNumberTest {
	@Test
	@DisplayName("getNumber")
	void test_getNumber1() {
		LottoNumber lottoNumber = new LottoNumber(1);

		assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
	}
}
