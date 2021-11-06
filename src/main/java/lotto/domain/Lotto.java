package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

	private static final int LOTTO_SIZE = 6;

	private final Set<LottoNumber> lottoNumbers;

	public Lotto(List<LottoNumber> numbers) {
		this.lottoNumbers = new HashSet<>();

		for (LottoNumber number : numbers) {
			this.lottoNumbers.add(number);
		}

		if (isLottoSize(this.lottoNumbers.size())) {
			throw new IllegalArgumentException();
		}
	}

	public boolean isContains(LottoNumber number) {
		return lottoNumbers.contains(number);
	}

	private boolean isLottoSize(int size) {
		return size != LOTTO_SIZE;
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
