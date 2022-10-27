package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class TestLottoNumbersFactory {

	public static LottoNumbers createLottoNumbers(int... numbers) {
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		for (int number : numbers) {
			LottoNumber lottoNumber = LottoNumber.of(number);
			lottoNumbers.add(lottoNumber);
		}
		return LottoNumbers.of(lottoNumbers);
	}
}
