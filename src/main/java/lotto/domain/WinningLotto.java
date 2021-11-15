package lotto.domain;

import java.util.Objects;

public class WinningLotto {

	public static final String ERROR_BONUS_NUMBER_DUPLICATE = "보너스 볼이 중복되었습니다.";
	private final Lotto winningLotto;
	private final LottoNumber bonusNumber;

	public WinningLotto(Lotto lotto, LottoNumber bonusNo) {
		this.winningLotto = lotto;
		this.bonusNumber = bonusNo;
		validation();
	}

	public WinningRecord match(Lottos lottos) {
		return new WinningRecord(lottos.match(winningLotto, bonusNumber));
	}

	private void validation() {
		if(isBonusNumberDuplicate()){
			throw new IllegalArgumentException(ERROR_BONUS_NUMBER_DUPLICATE);
		}
	}

	private boolean isBonusNumberDuplicate() {
		return winningLotto.contains(bonusNumber);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		WinningLotto that = (WinningLotto)o;
		return Objects.equals(winningLotto, that.winningLotto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(winningLotto);
	}
}
