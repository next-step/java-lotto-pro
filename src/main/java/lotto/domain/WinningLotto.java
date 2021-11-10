package lotto.domain;

import java.util.Objects;
import java.util.Set;

public class WinningLotto {

	public static final String ERROR_BONUS_NUMBER_DUPLICATE = "보너스 볼이 중복되었습니다.";
	private final Lotto winningLotto;

	public WinningLotto(Set<LottoNumber> numbers) {
		this.winningLotto = new Lotto(numbers);
	}

	public WinningRecord match(Lottos lottos, LottoNumber bonusNumber) {
		validation(bonusNumber);
		return new WinningRecord(lottos.match(this.winningLotto, bonusNumber));
	}

	private void validation(LottoNumber bonusNumber) {
		if(isBonusNumberDuplicate(bonusNumber)){
			throw new IllegalArgumentException(ERROR_BONUS_NUMBER_DUPLICATE);
		}
	}

	private boolean isBonusNumberDuplicate(LottoNumber bonusNumber) {
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
