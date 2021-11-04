package lottogame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoNumberMakerTest {

	private static final int START_INCLUSIVE_NUMBER = 1;    /* 로또 번호 최소값 */
	private static final int END_EXCLUSIVE_NUMBER = 45;    /* 로또 번호 최대값 */
	private static final int SIZE_OF_LOTTERY_NUMBERS = 6;

	@Test
	public void makeLottoNumbers_1에서45사이_6개의_숫자생성() {
		LottoNumberGroup lottoNumbers = LottoNumberMaker.makelottoNumbers();

		assertThat(lottoNumbers.getLottoNumbers().size()).isEqualTo(SIZE_OF_LOTTERY_NUMBERS);

		lottoNumbers.getLottoNumbers()
			.forEach(lottoNumber -> assertThat(lottoNumber.getNumber())
				.isBetween(START_INCLUSIVE_NUMBER, END_EXCLUSIVE_NUMBER));
	}
}
