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

	@Test
	@DisplayName("숫자가 아닌 문자열을 전달하면 예외")
	void test_constructor2() {
		assertThatThrownBy(() -> new LottoNumber("exception"))
			.isInstanceOf(NumberFormatException.class);
	}

	@Test
	@DisplayName("숫자인 문자열이지만 범위가 벗어날 때 예외")
	void test_constructor3() {
		assertThatThrownBy(() -> new LottoNumber("122"))
			.isInstanceOf(OutOfRangeException.class)
			.hasMessage(LottoNumber.MESSAGE_OUT_OF_RANGE);
	}

	@Test
	@DisplayName("범위 내의 숫자를 전달하면 성공")
	void test_constructor4() {
		assertThatNoException().isThrownBy(() -> new LottoNumber(23));
	}

	@Test
	@DisplayName("범위 내의 숫자인 문자열을 전달하면 성공")
	void test_constructor5() {
		assertThatNoException().isThrownBy(() -> new LottoNumber("23"));
	}
}
