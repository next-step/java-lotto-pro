package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {
	@Test
	@DisplayName("LottoNubmers 생성 테스트")
	void create() {
		LottoNumbers numbers = new LottoNumbers(Arrays.asList(
			new LottoNumber(2),
			new LottoNumber(4),
			new LottoNumber(5),
			new LottoNumber(7),
			new LottoNumber(23),
			new LottoNumber(34)
		));
		LottoNumbers numbers2 = new LottoNumbers(Arrays.asList(
			new LottoNumber(2),
			new LottoNumber(4),
			new LottoNumber(5),
			new LottoNumber(7),
			new LottoNumber(23),
			new LottoNumber(34)
		));
		assertThat(numbers).isEqualTo(numbers2);
	}

	@Test
	@DisplayName("LottoNubmers 문자열 형식 테스트")
	void toStringFormat() {
		LottoNumbers numbers = new LottoNumbers(Arrays.asList(
			new LottoNumber(2),
			new LottoNumber(4),
			new LottoNumber(5),
			new LottoNumber(7),
			new LottoNumber(23),
			new LottoNumber(34)
		));
		String result = numbers.toString();

		assertThat(result).isEqualTo("[2, 4, 5, 7, 23, 34]");
	}
}
