package step3;

import static java.util.stream.Collectors.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class LottoNumbers {
	public static final int LOTTO_NUMBER_MAX = 6;
	private Set<LottoNumber> lottoNumbers = new HashSet<>();

	public LottoNumbers(Set<LottoNumber> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
		validation();
	}

	public static LottoNumbers createLottoNumber(Set<LottoNumber> inputLottoNumber) {
		return new LottoNumbers(inputLottoNumber);
	}

	public static LottoNumbers createLottoNumber(Integer ...inputLottoNumber) {
		return new LottoNumbers(from(inputLottoNumber));
	}

	private void validation() {
		if (isOverFlow()) {
			throw new ArrayIndexOutOfBoundsException("로또 번호가 6개 이상 뽑혔습니다.");
		}
	}

	private boolean isOverFlow() {
		return lottoNumbers.size() > LOTTO_NUMBER_MAX;
	}

	private static Set<LottoNumber> from(Integer[] inputLottoNumber) {
		return Stream.of(inputLottoNumber)
			.map(LottoNumber::new)
			.collect(toCollection(HashSet::new));
	}

	public long match(LottoNumber lottoNumber) {
		return lottoNumbers.stream().filter(s -> s.equals(lottoNumber)).count();
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

	@Override
	public String toString() {
		return String.valueOf(lottoNumbers);
	}

}
