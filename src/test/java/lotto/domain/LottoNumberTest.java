package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
	public static IntStream provideLottoNumber() {
		return IntStream.range(1, 45);
	}

	@DisplayName("유효 범위 내의 로또 번호 생성")
	@ParameterizedTest
	@MethodSource("provideLottoNumber")
	void validLottoNumber(int number) {
		LottoNumber lottoNumber = LottoNumber.of(number);

		assertThat(lottoNumber).isEqualTo(LottoNumber.of(number));
	}

	@DisplayName("유효 범위 외의 로또 번호 생성")
	@ParameterizedTest
	@ValueSource(ints = {0, 80, 120})
	void invalidLottoNumber(int number) {
		assertThatThrownBy(() -> LottoNumber.of(number))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("로또 번호는 1 ~ 45 사이의 값을 입력하세요.");
	}

}
