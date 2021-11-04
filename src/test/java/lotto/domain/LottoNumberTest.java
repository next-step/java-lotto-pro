package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

	@Test
	@DisplayName("로또 번호를 추가하거나 에러 발생")
	public void addTest() {
		// given
		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);

		// when
		LottoNumber lottoNumber = LottoNumber.of(numbers1);

		// then
		List<Integer> integers = lottoNumber.getNumbers();
		assertThat(integers).containsAll(numbers1);
	}

	@Test
	@DisplayName("로또 숫자는 6개의 1~45 범위의 숫자로 이루어져야 한다")
	public void validateTest() {
		// given
		List<Integer> duplicateNumbers = Arrays.asList(1, 1, 3, 4, 5, 6);
		List<Integer> notEnoughNumbers = Arrays.asList(1, 2, 3);
		List<Integer> outRangeNumbers = Arrays.asList(0, 1, 2, 3, 4, 90);

		// when, then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> LottoNumber.of(duplicateNumbers))
			.withMessageContaining("중복이 있으면 안됩니다");
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> LottoNumber.of(notEnoughNumbers))
			.withMessageContaining("6개의 숫자로 되어야 합니다");
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> LottoNumber.of(outRangeNumbers))
			.withMessageContaining("1이상 45이하인 숫자여야 합니다");
	}

	@Test
	@DisplayName("서로 일치하는 숫자 갯수를 반환해야 한다")
	public void getMatchCountTest() {
		LottoNumber lottoNumber = LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoNumber lottoNumber2 = LottoNumber.of(Arrays.asList(1, 2, 3, 9, 10, 11));

		int result = lottoNumber.getMatchCount(lottoNumber2);

		assertThat(result).isEqualTo(3);
	}

}
