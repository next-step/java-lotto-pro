package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import lotto.code.ErrorCode;
import lotto.exception.LottoException;
import lotto.util.SplitUtil;

public class WinningLottoNumbers {
	private static final int COUNT_VALUE = 1;
	private static final int NOT_COUNT_VALUE = 0;

	private LottoNumbers winninglottoNumbers;

	public WinningLottoNumbers() {
	}

	public WinningLottoNumbers(String input) {
		this.winninglottoNumbers = generateWinningLottoNumbers(input);
	}

	private void isNotLottoNumberSize(String input) {
		if (SplitUtil.splitInputNumbers(input).length != LottoNumbers.LOTTO_NUMBERS_SIZE) {
			throw new LottoException(ErrorCode.IS_NOT_LOTTO_NUMBER_SIZE_ERROR);
		}
	}

	private void isDuplicateLottoNumber(String input) {
		Set<String> lottoNumberSet = new HashSet<>(Arrays.asList(SplitUtil.splitInputNumbers(input)));

		if (lottoNumberSet.size() != LottoNumbers.LOTTO_NUMBERS_SIZE) {
			throw new LottoException(ErrorCode.LOTTO_NUMBER_DUPLICATE_ERROR);
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

	public int containsCountLottoNumber(LottoNumber lottoNumber) {
		if (containsLottoNumber(lottoNumber)) {
			return COUNT_VALUE;
		}
		return NOT_COUNT_VALUE;
	}
}
