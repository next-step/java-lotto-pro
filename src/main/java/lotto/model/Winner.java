package lotto.model;

public class Winner {
	private final Lotto lotto;
	private final LottoNumber bonusNumber;

	public Winner(final Lotto lotto, final LottoNumber bonusNumber) {
		validate(lotto, bonusNumber);
		this.lotto = lotto;
		this.bonusNumber = bonusNumber;
	}

	private void validate(final Lotto lotto, final LottoNumber bonusNumber) {
		if (lotto.matchBonus(bonusNumber)) {
			throw new IllegalArgumentException("보너스 번호는 승리 번호에 포함될 수 없다.");
		}
	}

	public Rank match(final Lotto playerLotto) {
		return Rank.match(lotto.match(playerLotto), playerLotto.matchBonus(bonusNumber));
	}
}
