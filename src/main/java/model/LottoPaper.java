package model;

import java.util.Collection;

import utility.Assert;

public final class LottoPaper implements Lotto {

	private final LottoNumbers lottoNumbers;

	private LottoPaper(LottoNumbers lottoNumbers) {
		Assert.notNull(lottoNumbers, "'lottoNumbers' must not be empty");
		this.lottoNumbers = lottoNumbers;
	}

	static LottoPaper from(LottoNumbers lottoNumbers) {
		return new LottoPaper(lottoNumbers);
	}

	static LottoPaper from(Collection<LottoNumber> lottoNumbers) {
		return new LottoPaper(LottoNumbers.from(lottoNumbers));
	}

	@Override
	public String toString() {
		return lottoNumbers.toString();
	}

	public LottoRank rank(WinnerLotto winnerLotto) {
		return LottoRank.byMatchCountAndBonus(
			lottoNumbers.containsCount(winnerLotto.numbers()), lottoNumbers.contains(winnerLotto.bonus()));
	}
}
