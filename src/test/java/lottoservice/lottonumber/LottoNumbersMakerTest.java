package lottoservice.lottonumber;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottonumber.LottoNumbersMaker;

public class LottoNumbersMakerTest {

	private static final int START_INCLUSIVE_NUMBER = 1;    /* 로또 번호 최소값 */
	private static final int END_EXCLUSIVE_NUMBER = 45;    /* 로또 번호 최대값 */
	private static final int SIZE_OF_LOTTERY_NUMBERS = 6;

	@Test
	public void makeLottoNumbers_1에서45사이_6개의_숫자생성() {
		List<LottoNumber> lottoNumbers = LottoNumbersMaker.makeLottoNumbers();
		assertThat(lottoNumbers.size()).isEqualTo(SIZE_OF_LOTTERY_NUMBERS);
		lottoNumbers
			.forEach(lottoNumber -> assertThat(lottoNumber.getNumber())
				.isBetween(START_INCLUSIVE_NUMBER, END_EXCLUSIVE_NUMBER));
	}
}
