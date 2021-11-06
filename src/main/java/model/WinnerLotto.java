package model;

import utility.Assert;

public final class WinnerLotto implements Lotto {

	private final LottoNumbers lottoNumbers;

	private final LottoNumber bonusNumber;

	private WinnerLotto(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
		Assert.notNull(lottoNumbers, "'lottoNumbers' must not be null");
		Assert.notNull(bonusNumber, "'bonusNumber' must not be null");
		Assert.isTrue(lottoNumbers.notContains(bonusNumber),
			String.format("lottoNumbers(%s) must not have bonusNumber(%s)", lottoNumbers, bonusNumber));
		this.lottoNumbers = lottoNumbers;
		this.bonusNumber = bonusNumber;
	}

	static WinnerLotto from(LottoNumbers numbers, LottoNumber bonusNumber) {
		return new WinnerLotto(numbers, bonusNumber);
	}

	public LottoNumbers numbers() {
		return lottoNumbers;
	}

	public LottoNumber bonus() {
		return bonusNumber;
	}

	@Override
	public String toString() {
		return "WinnerLotto{" +
			"lottoNumbers=" + lottoNumbers +
			", bonusNumber=" + bonusNumber +
			'}';
	}
}
