package model;

import java.util.Collection;

public final class LottoPaper implements Lotto {

	private final LottoNumbers lottoNumbers;

	private LottoPaper(LottoNumbers lottoNumbers) {
		validate(lottoNumbers);
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

	private void validate(LottoNumbers lottoNumbers) {
		if (lottoNumbers == null) {
			throw new IllegalArgumentException("'lottoNumbers' must not be empty");
		}
	}
}
