package lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class WinningLotto {

	public static final int ZERO = 0;
	public static final int ADD = 1;

	private final List<LottoNumber> lottoNumbers;

	WinningLotto(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
	}

	public Rank match(Lotto lotto) {
		int matchCount = ZERO;
		for (LottoNumber lottoNumber : lottoNumbers) {
			matchCount += addMatchCount(lotto, lottoNumber);
		}
		return Rank.rank(matchCount);
	}

	private int addMatchCount(Lotto lotto, LottoNumber lottoNumber) {
		if (lotto.isContains(lottoNumber)) {
			return ADD;
		}
		return ZERO;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		WinningLotto that = (WinningLotto)o;
		return Objects.equals(lottoNumbers, that.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}
}
