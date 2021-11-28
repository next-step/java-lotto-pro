package lotto.domain.wrapper;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoNumberTest {

	@DisplayName("로또 번호의 범위 외 값 입력 시 예외")
	@ParameterizedTest
	@CsvSource(value = {
		"0",
		"46",
	})
	public void throwExceptionWhenNumberOutOfRange(int number) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new LottoNumber(number))
			.withMessage("로또 번호의 범위를 벗어났습니다.");
	}
}
