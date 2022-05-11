package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.model.LottoNumber;

public class LottoUtil {
	public static final int LOTTO_NUMBERS_COUNT = 6;
	public static final int MIN_LOTTO_NUMBER = 1;
	public static final int MAX_LOTTO_NUMBER = 45;
	
	public static List<LottoNumber> randomLottoNumbers() {
		List<LottoNumber> lottoNumbers = new ArrayList<LottoNumber>();
		for (int i=MIN_LOTTO_NUMBER; i<=MAX_LOTTO_NUMBER; ++i) {
			lottoNumbers.add(new LottoNumber(i));
		}
		Collections.shuffle(lottoNumbers);
		return lottoNumbers.subList(0, LOTTO_NUMBERS_COUNT);
	}
}
