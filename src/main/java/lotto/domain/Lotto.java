package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {
	public static final String NUMBER_COUNT_ERROR = "Lotto 번호는 6개 여야 합니다.";
	public static final String DUPLICATED_NUMBER_ERROR = "중복된 값이 포함되어 있습니다.";

	private final List<LottoNumber> lottoNumbers;

	private Lotto(final List<LottoNumber> numbers) {
		validateNumberCount(numbers);
		validateNonDuplicated(numbers);

		this.lottoNumbers = numbers;
	}

	public static Lotto from(final List<Integer> numbers) {
		List<LottoNumber> lottoNumbers = new ArrayList<>();

		for (Integer number : numbers) {
			LottoNumber lottoNumber = LottoNumber.from(number);
			lottoNumbers.add(lottoNumber);
		}

		return new Lotto(lottoNumbers);
	}

	public List<LottoNumber> numbers() {
		return Collections.unmodifiableList(lottoNumbers);
	}

	public int countMatch(final Lotto targetLotto) {
		int matchCount = 0;

		for (LottoNumber targetNumber: targetLotto.lottoNumbers) {
			matchCount += Collections.frequency(lottoNumbers, targetNumber);
		}

		return matchCount;
	}

	public boolean contains(final LottoNumber number) {
		return lottoNumbers.contains(number);
	}

	private void validateNonDuplicated(final List<LottoNumber> numbers) {
		Set<LottoNumber> numberSet = new HashSet<>(numbers);

		if (numberSet.size() != Common.LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR);
		}
	}

	private void validateNumberCount(final List<LottoNumber> numbers) {
		if (numbers.size() != Common.LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException(NUMBER_COUNT_ERROR);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lotto lotto = (Lotto)o;
		return Objects.equals(lottoNumbers, lotto.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}

	@Override
	public String toString() {
		return "Lotto{" +
			"lottoNumbers=" + lottoNumbers +
			'}';
	}
}
