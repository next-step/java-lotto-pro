package lotto.domain;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.exception.InvalidLottoNumberException;

public class LottoNumbers {

	private static final String INVALID_LOTTO_NUMBERS_COUNT_MESSAGE = "로또 번호는 중복되지 않는 6개의 숫자여야 합니다.";
	private static final String LOTTO_NUMBER_DELIMITER = ", ";
	private final Set<LottoNumber> lottoNumbers;

	private LottoNumbers(Set<LottoNumber> lottoNumbers) {
		validate(lottoNumbers);
		this.lottoNumbers = lottoNumbers;
	}

	private void validate(Set<LottoNumber> lottoNumbers) {
		if (lottoNumbers.size() != LottoInfo.MAX_LOTTO_NUMBER_SIZE.getValue()) {
			throw new InvalidLottoNumberException(INVALID_LOTTO_NUMBERS_COUNT_MESSAGE);
		}
	}

	public static LottoNumbers from(Set<Integer> lottoNumbers) {
		Set<LottoNumber> lottoNumberSet = getLottoNumbers(lottoNumbers);
		return new LottoNumbers(lottoNumberSet);
	}

	private static Set<LottoNumber> getLottoNumbers(Set<Integer> lottoNumbers) {
		return lottoNumbers.stream()
			.map(LottoNumber::from)
			.collect(Collectors.toSet());
	}

	@Override
	public String toString() {
		return lottoNumbers.stream()
			.map(LottoNumber::toString)
			.sorted(Comparator.comparing(Integer::parseInt))
			.collect(Collectors.joining(LOTTO_NUMBER_DELIMITER));
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

	public int matchCount(LottoNumbers purchaseLottoNumbers) {
		return (int) this.lottoNumbers.stream()
			.filter(purchaseLottoNumbers.lottoNumbers::contains)
			.count();
	}
}
