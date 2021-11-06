package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

	@Test
	@DisplayName("로또 번호들로 생성할 수 있다")
	public void initTest() {
		// given
		LottoNumber number1 = LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoNumber number2 = LottoNumber.of(Arrays.asList(7, 8, 9, 10, 11, 12));

		// when
		LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(number1, number2));

		// then
		assertThat(lottoNumbers.getSize()).isEqualTo(2);

	}

	@Test
	@DisplayName("로또 번호들을 추가할 수 있다")
	public void addTest() {
		// given
		LottoNumber number1 = LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoNumber number2 = LottoNumber.of(Arrays.asList(7, 8, 9, 10, 11, 12));

		// when
		LottoNumbers lottoNumbers = new LottoNumbers();
		lottoNumbers.add(number1);
		lottoNumbers.add(number2);

		// then
		assertThat(lottoNumbers.getSize()).isEqualTo(2);
	}

	@Test
	@DisplayName("로또 번호들을 얻을 수 있다")
	public void getTest() {
		// given
		LottoNumber number1 = LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoNumber number2 = LottoNumber.of(Arrays.asList(7, 8, 9, 10, 11, 12));
		List<LottoNumber> expected = Arrays.asList(number1, number2);
		LottoNumbers lottoNumbers = new LottoNumbers(expected);

		// when
		List<LottoNumber> numberList = lottoNumbers.getNumbers();

		// then
		assertThat(numberList).containsAll(expected);
	}
}
