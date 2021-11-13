package lotto.domain;

public class WinningLotto {
	private final Lotto winningNumbers;
	private final LottoNumber bonusBallNumber;

	public WinningLotto(final String winningNumbers, final int bonusBallNumber) {
		this.winningNumbers = new Lotto(winningNumbers);
		this.bonusBallNumber = new LottoNumber(bonusBallNumber);
	}

	public Rank getRank(Lotto lotto) {
		int countOfMatch = winningNumbers.matchCount(lotto);
		boolean bonusNumberMatch = lotto.isMatch(bonusBallNumber);
		return Rank.checkRank(countOfMatch, bonusNumberMatch);
	}
}