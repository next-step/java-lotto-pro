package lotto.domain;

public class WinningLotto {
	public static final String BONUS_NUMBER_NOT_CORRECT = "보너스 번호는 당첨 번호와 다른 번호여야 합니다.";

	private final Lotto lotto;
	private final LottoNumber bonusNumber;

	public WinningLotto(final Lotto lotto, final int number) {
		this.lotto = lotto;
		this.bonusNumber = LottoNumber.from(number);

		validateBonusNumber(lotto);
	}

	private void validateBonusNumber(Lotto lotto) {
		if (lotto.contains(bonusNumber)) {
			throw new IllegalArgumentException(BONUS_NUMBER_NOT_CORRECT);
		}
	}

	public Rank match(final Lotto userLotto) {
		int matchCount = lotto.countMatch(userLotto);
		boolean matchBonus = userLotto.contains(bonusNumber);
		return Rank.from(matchCount, matchBonus);
	}
}
