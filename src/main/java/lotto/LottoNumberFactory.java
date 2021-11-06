package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberFactory {
	private static final List<Integer> allLottoNumbers = new ArrayList<>();

	static {
		for (int i = CommonConstant.MIN_BOUNDARY_NUMBER; i <= CommonConstant.MAX_BOUNDARY_NUMBER; i++) {
			allLottoNumbers.add(i);
		}
	}

	public static List<Integer> create() {
		Collections.shuffle(allLottoNumbers);
		List<Integer> lottoNumbers = allLottoNumbers.subList(CommonConstant.FIRST_INDEX, CommonConstant.SIX_INDEX);
		Collections.sort(lottoNumbers);
		return lottoNumbers;
	}
}
