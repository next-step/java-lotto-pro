package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

	private static final int LOTTO_SIZE = 6;

	private final List<LottoNumber> lottoNumbers;

	public Lotto(List<Integer> numbers) {

		Set<Integer> numbersCheck = new HashSet<>(numbers);
		if (isLottoSize(numbersCheck.size())) {
			throw new IllegalArgumentException("##");
		}

		this.lottoNumbers = Collections.unmodifiableList(numbers.stream()
			.sorted()
			.map(LottoNumber::new)
			.collect(Collectors.toList()));

	}

	public boolean isContains(LottoNumber number) {
		return lottoNumbers.contains(number);
	}

	private boolean isLottoSize(int size) {
		return LOTTO_SIZE != size;
	}

	@Override
	public String toString() {
		return "[" + String.join(",", this.lottoNumbers.toString()) + "]";
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
