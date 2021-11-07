package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberFactory {
	private static final int FIRST_INDEX = 0;
	private static final int SIX_INDEX = 6;
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;
	private static final List<Integer> allLottoNumbers = new ArrayList<>();

	static {
		for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
			allLottoNumbers.add(i);
		}
	}

	public static List<Integer> create() {
		Collections.shuffle(allLottoNumbers);
		List<Integer> lottoNumbers = allLottoNumbers.subList(FIRST_INDEX, SIX_INDEX);
		Collections.sort(lottoNumbers);
		return lottoNumbers;
	}
}
