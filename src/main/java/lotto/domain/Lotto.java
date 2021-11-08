package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

	private static final int LOTTO_SIZE = 6;
	public static final String INVALID_NUMBER = "번호가 올바르지 않습니다.";

	private final List<LottoNumber> lottoNumbers;

	public Lotto(List<Integer> numbers) {

		Set<Integer> numbersCheck = new HashSet<>(numbers);
		if (isLottoSize(numbersCheck.size())) {
			throw new IllegalArgumentException(INVALID_NUMBER);
		}

		this.lottoNumbers = Collections.unmodifiableList(numbers.stream()
			.sorted()
			.map(LottoNumber::new)
			.collect(Collectors.toList()));

	}

	private boolean isLottoSize(int size) {
		return LOTTO_SIZE != size;
	}

	public Rank match(Lotto lotto) {
		return Rank.rank(this.lottoNumbers.stream()
			.filter(lotto.lottoNumbers::contains)
			.count());
	}

	@Override
	public String toString() {
		return String.join(",", this.lottoNumbers.toString());
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
