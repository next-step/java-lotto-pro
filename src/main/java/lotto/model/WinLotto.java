package lotto.model;

import lotto.constants.Rank;

public class WinLotto {
	private final Lotto lotto;
	private final LottoNumber lottoNumber;

	public WinLotto(Lotto lotto, LottoNumber lottoNumber) {
		this.lotto = lotto;
		this.lottoNumber = lottoNumber;
	}

	public Rank compare(Lotto lotto) {
		int sameCount = this.lotto.compareNumbers(lotto);
		return Rank.valueOf(sameCount, lotto.contains(lottoNumber));
	}
}
