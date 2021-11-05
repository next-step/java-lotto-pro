package step3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LottoNumbers {
	private final Set<LottoNumber> lottoNumbers;
	private final int LOTTO_NUMBER_MAX = 6;

	public LottoNumbers(Set<LottoNumber> lottoNumbers) {
		this.lottoNumbers = Collections.unmodifiableSet(lottoNumbers);
	}

	public LottoNumbers() {
		this.lottoNumbers = new HashSet<>();
	}

	public Set<LottoNumber> createLottoNumbers() {
		for (int i = 0; i < LOTTO_NUMBER_MAX; i++) {
			validation();
			lottoNumbers.add(new LottoNumber(RandomUtils.pick()));
		}
		return this.lottoNumbers;
	}

	private void validation() {
		if (isOverFlow()) {
			throw new ArrayIndexOutOfBoundsException("로또 번호가 6개 이상 뽑혔습니다.");
		}
	}

	private boolean isOverFlow() {
		return this.lottoNumbers.size() > LOTTO_NUMBER_MAX;
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

}
