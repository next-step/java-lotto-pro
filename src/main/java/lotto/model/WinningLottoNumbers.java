package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import lotto.util.SplitUtil;

public class WinningLottoNumbers {

	private LottoNumbers winninglottoNumbers;

	public WinningLottoNumbers() {
	}

	public WinningLottoNumbers(String input) {
		this.winninglottoNumbers = generateWinningLottoNumbers(input);
	}

	private void isNotLottoNumberSize(String input) {
		if (SplitUtil.splitInputNumbers(input).length != LottoNumbers.LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException();
		}
	}

	private void isDuplicateLottoNumber(String input) {
		Set<String> lottoNumberSet = new HashSet<>(Arrays.asList(SplitUtil.splitInputNumbers(input)));

		if (lottoNumberSet.size() != LottoNumbers.LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException();
		}
	}

	private LottoNumbers generateWinningLottoNumbers(String input) {
		isNotLottoNumberSize(input);
		isDuplicateLottoNumber(input);

		return new LottoNumbers(input);
	}

	public int size() {
		return winninglottoNumbers.size();
	}

	public boolean containsLottoNumber(LottoNumber lottoNumber) {
		return winninglottoNumbers.containsLottoNumber(lottoNumber);
	}
}
