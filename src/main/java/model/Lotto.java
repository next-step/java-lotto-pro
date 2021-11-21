package model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import calculator.StringSplitParser;

public class Lotto {
	public static final String MESSAGE_NOT_ALLOW_LENGTH = "LOTTO_NUMBERS_LENGTH_MUST_BE_6";
	public static final String MESSAGE_NOT_ALLOW_DUPLICATION = "LOTTO_NUMBERS_ELEMENT_MUST_BE_INDEPENDENT";
	public static final int LOTTO_NUMBERS_LENGTH = 6;

	private final List<LottoNumber> lottoNumbers;

	public Lotto(List<Integer> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_NUMBERS_LENGTH) {
			throw new IllegalArgumentException(MESSAGE_NOT_ALLOW_LENGTH);
		}
		validateDuplication(lottoNumbers);

		this.lottoNumbers = lottoNumbers.stream()
			.map(LottoNumber::new)
			.collect(Collectors.toList());
		sortLottoNumbers(this.lottoNumbers);
	}

	public Lotto(String lottoNumbersString) {
		this(parse(lottoNumbersString));
	}

	public Rank calcLottoResult(Lotto winningLotto, LottoNumber bonusNumber) {
		LottoResult lottoResult = new LottoResult();
		for (LottoNumber winningLottoNumber : winningLotto.lottoNumbers) {
			containWinningLottoNumber(winningLottoNumber, lottoResult);
		}
		return lottoResult.getRank(lottoNumbers.contains(bonusNumber));
	}

	private void containWinningLottoNumber(LottoNumber winningLottoNumber, LottoResult lottoResult) {
		if (lottoNumbers.contains(winningLottoNumber)) {
			lottoResult.addMatchingCount();
		}
	}

	private static List<Integer> parse(String lottoNumbersString) {
		return StringSplitParser.parse(lottoNumbersString);
	}

	private void sortLottoNumbers(List<LottoNumber> lottoNumbers) {
		lottoNumbers.sort(LottoNumber::getComparatorOther);
	}

	private void validateDuplication(List<Integer> lottoNumbers) {
		Set<Integer> lottoNumbersWithoutDuplication = new HashSet<>(lottoNumbers);
		if (lottoNumbersWithoutDuplication.size() != lottoNumbers.size()) {
			throw new IllegalArgumentException(MESSAGE_NOT_ALLOW_DUPLICATION);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lotto that = (Lotto)o;
		return Objects.equals(lottoNumbers, that.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}

	@Override
	public String toString() {
		return lottoNumbers.toString();
	}
}
