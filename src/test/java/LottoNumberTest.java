import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.OutOfRangeException;
import model.LottoNumber;

public class LottoNumberTest {
	@Test
	@DisplayName("getNumber")
	void test_getNumber1() {
		LottoNumber lottoNumber = new LottoNumber(1);

		assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
	}


	@Test
	@DisplayName("로또 숫자가 범위를 벗어난 값을 가질 때 예외")
	void test_constructor1() {
		assertThatThrownBy(() -> new LottoNumber(122))
			.isInstanceOf(OutOfRangeException.class)
			.hasMessage(LottoNumber.MESSAGE_OUT_OF_RANGE);
	}
}
