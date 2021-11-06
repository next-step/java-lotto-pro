package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {
	@Test
	@DisplayName("LottoNubmers 생성 테스트")
	void create() {
		LottoNumbers numbers = new LottoNumbers(2,4,5,7,23,34);
		LottoNumbers numbers2 = new LottoNumbers(2,4,5,7,23,34);
		assertThat(numbers).isEqualTo(numbers2);
	}

	@Test
	@DisplayName("LottoNubmers 문자열 형식 테스트")
	void toStringFormat() {
		LottoNumbers numbers =new LottoNumbers(2,4,5,7,23,34);
		String result = numbers.toString();

		assertThat(result).isEqualTo("[2, 4, 5, 7, 23, 34]");
	}
}
