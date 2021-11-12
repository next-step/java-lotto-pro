package step3.winner;

import step3.lotto.BonusBall;
import step3.lotto.LottoNumbers;
import step3.lotto.LottoPapers;

public class Winning {

	private LottoNumbers lottoNumbers;
	private BonusBall bonusBall;

	public Winning(LottoNumbers winningLottoNumbers, BonusBall bonusBall) {
		this.lottoNumbers = winningLottoNumbers;
		this.bonusBall = bonusBall;
		validation();
	}

	public Winning(LottoNumbers winningLottoNumbers, int bonusBall) {
		this(winningLottoNumbers, new BonusBall(bonusBall));
	}

	private void validation() {
		if (lottoNumbers.matchBonusBall(bonusBall)) {
			throw new IllegalArgumentException("보너스 번호가 당첨 번호와 동일할 수 없습니다");
		}
	}

	public WinningResult match(LottoPapers lottoPapers) {
		return lottoPapers.findMatchWinningResult(lottoNumbers, bonusBall);
	}
}
