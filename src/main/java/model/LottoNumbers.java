package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
	public static final String MESSAGE_NOT_ALLOW_LENGTH = "LOTTO_NUMBERS_LENGTH_MUST_BE_6";
	public static final String MESSAGE_NOT_ALLOW_DUPLICATION = "LOTTO_NUMBERS_ELEMENT_MUST_BE_INDEPENDENT";
	public static final int LOTTO_NUMBERS_LENGTH = 6;

	private final List<LottoNumber> lottoNumbers;

	public LottoNumbers(List<LottoNumber> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_NUMBERS_LENGTH) {
			throw new IllegalArgumentException(MESSAGE_NOT_ALLOW_LENGTH);
		}
		validateDuplication(lottoNumbers);

		this.lottoNumbers = new ArrayList<>();
		sortLottoNumbers(lottoNumbers);
		this.lottoNumbers.addAll(lottoNumbers);
	}

	private void sortLottoNumbers(List<LottoNumber> lottoNumbers) {
		lottoNumbers.sort(LottoNumber::getComparatorOther);
	}

	private void validateDuplication(List<LottoNumber> lottoNumbers) {
		for (int i = 0; i < lottoNumbers.size(); ++i) {
			validateDuplication(lottoNumbers, i);
		}
	}

	private void validateDuplication(List<LottoNumber> lottoNumbers, int i) {
		for (int j = i + 1; j < lottoNumbers.size(); ++j) {
			validateDuplication(lottoNumbers, i, j);
		}
	}

	private void validateDuplication(List<LottoNumber> lottoNumbers, int i, int j) {
		if (lottoNumbers.get(i).equals(lottoNumbers.get(j))) {
			throw new IllegalArgumentException(MESSAGE_NOT_ALLOW_DUPLICATION);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumbers that = (LottoNumbers)o;
		return Objects.equals(lottoNumbers, that.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}
}
