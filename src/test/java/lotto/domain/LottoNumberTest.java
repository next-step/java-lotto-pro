package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoNumberTest {

	public static List<Arguments> getInvalidNumbers() {
		return Lists.list(
			arguments(Arrays.asList(1, 2, 3, 4, 5, 90)),
			arguments(Arrays.asList(1, 2, 3)),
			arguments(Arrays.asList(1, 2, 3, 4, 5, 0))
		);
	}

	@Test
	@DisplayName("로또 번호를 추가하거나 에러 발생")
	public void addTest() {
		// given
		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);

		// when
		LottoNumber lottoNumber = new LottoNumber(numbers1);

		// then
		List<Integer> integers = lottoNumber.getNumbers();
		assertThat(integers).containsAll(numbers1);
	}

	@ParameterizedTest
	@MethodSource("getInvalidNumbers")
	@DisplayName("잘못된 로또 번호를 추가할 시, IllegalArgumentException 발생")
	public void validateTest(List<Integer> numbers) {
		// when, then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new LottoNumber(numbers));
	}

	@Test
	@DisplayName("서로 일치하는 숫자 갯수를 반환해야 한다")
	public void getMatchCountTest() {
		LottoNumber lottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoNumber lottoNumber2 = new LottoNumber(Arrays.asList(1, 2, 3, 9, 10, 11));

		int result = lottoNumber.getMatchCount(lottoNumber2);

		assertThat(result).isEqualTo(3);
	}

}
