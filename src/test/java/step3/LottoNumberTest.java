package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoNumberTest {

	@DisplayName("로또 번호는 1 ~ 45까지 숫자이어야합니다.")
	@ParameterizedTest()
	@CsvSource(value = {"-1","46","0"})
	void lottoNumberIsMinOneAndMaxFiftyFive(int number) {
		Assertions.assertThatThrownBy(() -> new LottoNumber(number))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
