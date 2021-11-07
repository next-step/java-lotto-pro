package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
	private static final int MATCHED_NUMBER_PLUS = 1;
	private static final int NON_MATCHED_NUMBER = 0;
	private final List<Integer> lottoNumbers = new ArrayList<>();

	public LottoNumbers(int... lottoNumbers) {
		for (int lottoNumber : lottoNumbers) {
			this.lottoNumbers.add(lottoNumber);
		}
	}

	public LottoNumbers(List<Integer> lottoNumbers) {
		for (Integer lottoNumber : lottoNumbers) {
			this.lottoNumbers.add(lottoNumber);
		}
	}

	public int isMatch(int winningNumber) {
		if (lottoNumbers.contains(winningNumber)) {
			return MATCHED_NUMBER_PLUS;
		}
		return NON_MATCHED_NUMBER;
	}

	public String StringValues() {
		return lottoNumbers.toString();
	}
}
