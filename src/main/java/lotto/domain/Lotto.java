package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

	private static final int LOTTO_SIZE = 6;
	public static final String INVALID_NUMBER = "중복되지 않은 6개의 숫자를 입력해주세요.";

	private final List<LottoNumber> lottoNumbers;

	public Lotto(Set<LottoNumber> numbers) {

		validationLotto(numbers);

		this.lottoNumbers = Collections.unmodifiableList(numbers.stream()
			.sorted()
			.collect(Collectors.toList()));

	}

	private void validationLotto(Set<LottoNumber> numbers) {
		if (isLottoSize(numbers.size())) {
			throw new IllegalArgumentException(INVALID_NUMBER);
		}
	}

	private boolean isLottoSize(int size) {
		return LOTTO_SIZE != size;
	}

	public Rank match(Lotto lotto) {
		return Rank.rank(this.lottoNumbers.stream()
			.filter(lotto.lottoNumbers::contains)
			.count());
	}

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lotto lotto1 = (Lotto)o;
		return Objects.equals(lottoNumbers, lotto1.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}
}
