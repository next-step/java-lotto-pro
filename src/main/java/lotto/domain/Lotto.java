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

	private static final int LOTTO_NUMBER_COUNT = 6;

	private final List<LottoNumber> lottoNumbers;

	public Lotto(List<Integer> numbers) {
		validateNumberCount(numbers);
		validateNonDuplicated(numbers);

		lottoNumbers = new ArrayList<>();

		for (Integer number : numbers) {
			LottoNumber lottoNumber = new LottoNumber(number);
			lottoNumbers.add(lottoNumber);
		}
	}

	public List<LottoNumber> numbers() {
		return Collections.unmodifiableList(lottoNumbers);
	}

	private void validateNonDuplicated(List<Integer> numbers) {
		Set<Integer> numberSet = new HashSet<>(numbers);

		if (numberSet.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR);
		}
	}

	private void validateNumberCount(List<Integer> numbers) {
		if (numbers.size() != LOTTO_NUMBER_COUNT) {
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
