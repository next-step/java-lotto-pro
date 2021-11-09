package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoShop {
	public static final int LOTTO_PRICE = 1000;
	private static final List<LottoNumber> allLottoNumbers = new ArrayList<>();

	static {
		for (int i = LottoNumber.MIN_BOUND; i <= LottoNumber.MAX_BOUND; i++) {
			allLottoNumbers.add(new LottoNumber(i));
		}
	}

	public static Lotto sell() {
		Collections.shuffle(allLottoNumbers);
		List<LottoNumber> lottoNumbers = allLottoNumbers.subList(LottoNumbers.MIN_RANGE_VALUE, LottoNumbers.MAX_RANGE_VALUE);
		Collections.sort(lottoNumbers, (l1, l2) -> Integer.compare(l1.getValue(), l2.getValue()));
		return new Lotto(new LottoNumbers(lottoNumbers));
	}

	public static Lotto sell(String lottoNumbers) {
		return new Lotto(new LottoNumbers(lottoNumbers));
	}
}
