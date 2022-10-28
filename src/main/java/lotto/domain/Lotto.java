package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
	public static final int PRICE = 1000;
	private static final int LOTTO_NUMBER_SIZE = 6;

	private final Set<LottoNumber> lottoNumbers;

	public Lotto(LottoNumberStrategy lottoNumberStrategy) {
		List<Integer> pickNumbers = lottoNumberStrategy.pickNumbers();
		validatePickNumbersSize(pickNumbers.size());
		this.lottoNumbers = pickNumbers.stream()
			.map(LottoNumber::new)
			.collect(Collectors.toSet());
	}

	private void validatePickNumbersSize(int size) {
		if (size != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException("로또 번호 갯수가 6개이여야 합니다.");
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
		return lottoNumbers.stream()
			.sorted()
			.map(Object::toString)
			.collect(Collectors.joining(", ", "[", "]"));
	}
}
