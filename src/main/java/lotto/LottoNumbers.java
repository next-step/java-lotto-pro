package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
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
			return CommonConstant.MATCHED_NUMBER_PLUS;
		}
		return CommonConstant.NON_MATCHED_NUMBER;
	}

	public String StringValues() {
		return lottoNumbers.toString();
	}
}
