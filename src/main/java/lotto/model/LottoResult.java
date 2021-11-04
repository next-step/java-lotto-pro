package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

	public int containsWinningLottoNumbers(WinningLottoNumbers winningLottoNumbers, LottoNumbers lottoNumbers) {
		int containsCount = 0;

		for (LottoNumber lottoNumber : lottoNumbers.lottoNumberList) {
			containsCount += winningLottoNumbers.containsCountLottoNumber(lottoNumber);
		}

		return containsCount;
	}

	public Map<Integer, Integer> containsWinningLottoGenerator(WinningLottoNumbers winningLottoNumbers,
		LottoGenerator lottoGenerator) {
		Map<Integer, Integer> containsMap = new HashMap<>();

		for (LottoNumbers lottoNumbers : lottoGenerator.getLottoNumbersList()) {
			int containsCount = containsWinningLottoNumbers(winningLottoNumbers, lottoNumbers);
			containsMap.put(containsCount, containsMap.getOrDefault(containsCount, 0) + 1);
		}

		return containsMap;
	}
}
