package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberFactory {
	private static final int MIN_BOUNDARY_NUMBER = 1;
	private static final int MAX_BOUNDARY_NUMBER = 45;
	private static final List<Integer> allLottoNumbers = new ArrayList<>();

	static {
		for (int i = MIN_BOUNDARY_NUMBER; i <= MAX_BOUNDARY_NUMBER; i++) {
			allLottoNumbers.add(i);
		}
	}

	public static List<Integer> create() {
		Collections.shuffle(allLottoNumbers);
		List<Integer> lottoNumbers = allLottoNumbers.subList(0, 6);
		Collections.sort(lottoNumbers);
		return lottoNumbers;
	}
}
