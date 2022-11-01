package lotto.domain.lotto;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.domain.match.count.MatchCount;

public class Lotto {
	public static final int LOTTO_NUMBERS_SIZE = 6;
	private final Set<LottoNumber> lottoNumbers;

	private Lotto(List<Integer> numbers) {
		Set<LottoNumber> lottoNumbers = convert(numbers);
		validateNumberSize(lottoNumbers.size());
		this.lottoNumbers = lottoNumbers;
	}

	public static Lotto from(List<Integer> numbers) {
		return new Lotto(numbers);
	}

	private Set<LottoNumber> convert(List<Integer> numbers) {
		return numbers.stream()
			.map(LottoNumber::from)
			.collect(Collectors.toSet());
	}

	private void validateNumberSize(long size) {
		if (size != LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException("로또 번호는 6자리여야 합니다.");
		}
	}

	public MatchCount countMatchCount(Lotto other) {
		return MatchCount.from(
			(int)lottoNumbers.stream()
				.filter(other::contains)
				.count()
		);
	}

	public boolean contains(LottoNumber lottoNumber) {
		return this.lottoNumbers.contains(lottoNumber);
	}

	public Set<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
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
}
