package lottoservice.matcher;

import lottoservice.lottonumber.LottoNumber;

public class LottoPrizeAnswer {

	private LottoWinningNumbers lottoWinningNumbers;
	private BonusNumber bonusNumber;

	public LottoPrizeAnswer(LottoWinningNumbers lottoWinningNumbers, BonusNumber bonusNumber) {
		this.lottoWinningNumbers = lottoWinningNumbers;
		this.bonusNumber = bonusNumber;
	}

	public boolean hasNumberInWinningNumbers(LottoNumber lottoNumber) {
		return lottoWinningNumbers.hasMatchNumber(lottoNumber);
	}

	public boolean isMatchBonusNumber(LottoNumber lottoNumber) {
		return bonusNumber.isMatchNumber(lottoNumber);
	}
}
