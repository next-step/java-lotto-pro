package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

	@ParameterizedTest
	@ValueSource(strings = { "a", "-1", "46" })
	@DisplayName("숫자가 아니거나, 1~45의 범위를 벗어난 문자열에 대해 예외 테스트")
	void create_lottoNumber_string_예외(String lottoNumber) {
		assertThrows(IllegalArgumentException.class, () -> new LottoNumber(lottoNumber));
	}

	@ParameterizedTest
	@ValueSource(ints = { -1, 46 })
	@DisplayName("1~45의 범위를 벗어난 숫자에 대해 예외 테스트")
	void create_lottoNumber_int_예외(int lottoNumber) {
		assertThrows(IllegalArgumentException.class, () -> new LottoNumber(lottoNumber));
	}

	@ParameterizedTest
	@ValueSource(strings = { "1", "10", "20", "30", "40", "45" })
	@DisplayName("1~45의 문자열에 대한 로또번호 생성 테스트")
	void create_lottoNumber_string(String lottoNumber) {
		assertEquals(new LottoNumber(lottoNumber), Integer.valueOf(lottoNumber));
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 10, 20, 30, 40, 45 })
	@DisplayName("1~45의 숫자에 대한 로또번호 생성 테스트")
	void create_lottoNumber_int(int lottoNumber) {
		assertEquals(new LottoNumber(lottoNumber), lottoNumber);
	}
}
