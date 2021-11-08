package lottoservice.lottonumber;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersMakerTest {

	private static final int START_INCLUSIVE_NUMBER = 1;    /* 로또 번호 최소값 */
	private static final int END_EXCLUSIVE_NUMBER = 45;    /* 로또 번호 최대값 */
	private static final int SIZE_OF_LOTTERY_NUMBERS = 6;

	private LottoNumbersMaker lottoNumbersMaker = new LottoNumbersMaker(new LottoArrangeManipulator());

	@DisplayName("1에서45사이_6개의_숫자생성")
	@Test
	public void makeLottoNumbers_shuffle_constructor() {
		List<LottoNumber> lottoNumbers = lottoNumbersMaker.makeLottoNumbers();
		assertThat(lottoNumbers.size()).isEqualTo(SIZE_OF_LOTTERY_NUMBERS);
		lottoNumbers
			.forEach(lottoNumber -> assertThat(lottoNumber.getNumber())
				.isBetween(START_INCLUSIVE_NUMBER, END_EXCLUSIVE_NUMBER));
	}

	@DisplayName("Integer 리스트 인자전달해서 생성")
	@Test
	public void makeLottoNumbers_constructor_integers() {
		List<Integer> numbers = Arrays.asList(1, 10, 20, 30, 40, 45);
		List<LottoNumber> lottoNumbers = lottoNumbersMaker.makeLottoNumbers(numbers);
		assertThat(lottoNumbers.size()).isEqualTo(SIZE_OF_LOTTERY_NUMBERS);
		for (int number : numbers) {
			assertThat(lottoNumbers.contains(LottoNumber.valueOf(number)));
		}
	}

	@DisplayName("문자열_인자전달")
	@Test
	public void makeLottoNumbers_constructor_string() {
		String numbertext = "1, 15, 20, 25, 30, 45";
		List<Integer> numbers = Arrays.asList(1, 15, 20, 25, 30, 45);
		List<LottoNumber> lottoNumbers = lottoNumbersMaker.makeLottoNumbers(numbertext);
		assertThat(lottoNumbers.size()).isEqualTo(SIZE_OF_LOTTERY_NUMBERS);
		for (int number : numbers) {
			assertThat(lottoNumbers.contains(LottoNumber.valueOf(number)));
		}
	}
}