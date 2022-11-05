package lotto.domain.lotto;

import java.util.Objects;

public class WinningLotto {
	private final Lotto winLotto;
	private final LottoNumber bonusNumber;

	public WinningLotto(String inputWinLotto, int inputBonusNumber) {
		Lotto winLotto = new InputLottoGenerator(inputWinLotto).generate();
		LottoNumber bonusNumber = LottoNumber.from(inputBonusNumber);
		validateDuplicateBonusNumber(winLotto, bonusNumber);
		this.winLotto = winLotto;
		this.bonusNumber = bonusNumber;
	}

	public static WinningLotto from(String input, int bonusBallInput) {
		return new WinningLotto(input, bonusBallInput);
	}

	private void validateDuplicateBonusNumber(Lotto winLotto, LottoNumber bonusNumber) {
		if (winLotto.contains(bonusNumber)) {
			throw new IllegalStateException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
		}
	}

	public LottoResults getLottoResults(Lottos lottos) {
		return lottos.toLottoResults(winLotto, bonusNumber);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		WinningLotto that = (WinningLotto)o;
		return Objects.equals(winLotto, that.winLotto) && Objects.equals(bonusNumber, that.bonusNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(winLotto, bonusNumber);
	}
}
