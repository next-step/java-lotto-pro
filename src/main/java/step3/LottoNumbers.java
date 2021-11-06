package step3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class LottoNumbers {
	private final Set<LottoNumber> lottoNumbers;
	public static final int LOTTO_NUMBER_MAX = 6;

	public LottoNumbers(Set<LottoNumber> lottoNumbers) {
		this.lottoNumbers = Collections.unmodifiableSet(lottoNumbers);
	}

	public LottoNumbers() {
		this.lottoNumbers = new HashSet<>();
	}

	public LottoNumbers createLottoNumbers() {
		while (isNotMaxNumber()) {
			validation();
			lottoNumbers.add(new LottoNumber(RandomUtils.pick()));
		}
		return new LottoNumbers(this.lottoNumbers);
	}

	private boolean isNotMaxNumber() {
		return LOTTO_NUMBER_MAX != lottoNumbers.size();
	}

	private void validation() {
		if (isOverFlow()) {
			throw new ArrayIndexOutOfBoundsException("로또 번호가 6개 이상 뽑혔습니다.");
		}
	}

	private boolean isOverFlow() {
		return this.lottoNumbers.size() > LOTTO_NUMBER_MAX;
	}

	public Integer match(LottoNumber lottoNumber) {
		int count = 0;
		Optional<LottoNumber> any = this.lottoNumbers.stream().filter(s -> s.equals(lottoNumber)).findAny();
		if (any.isPresent()) {
			count++;
		}
		return new Integer(count);
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
