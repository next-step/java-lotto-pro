package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
	private final Set<LottoNumber> lottoNumbers;

	private Lotto(LottoNumberStrategy lottoNumberStrategy) {
		this.lottoNumbers = lottoNumberStrategy.pickNumbers();
	}

	public static Lotto inputNumber(List<Integer> numbers) {
		return new Lotto(new InputLottoNumberStrategy(numbers));
	}

	public static Lotto random() {
		return new Lotto(new RandomLottoNumberStrategy());
	}

	public int countMatchLottoNumber(Lotto other) {
		return (int)lottoNumbers.stream()
			.filter(other::contains)
			.count();
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

	public boolean contains(LottoNumber lottoNumber) {
		return this.lottoNumbers.contains(lottoNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}

	public String getResultMessage() {
		return lottoNumbers.stream()
			.sorted()
			.map(Object::toString)
			.collect(Collectors.joining(", ", "[", "]"));
	}

}
