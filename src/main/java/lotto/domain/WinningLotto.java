package lotto.domain;

import java.util.Objects;
import java.util.Set;

public class WinningLotto {

	private final Lotto winningLotto;

	public WinningLotto(Set<LottoNumber> numbers) {
		this.winningLotto = new Lotto(numbers);
	}

	public WinningRecord match(Lottos lottos) {
		return new WinningRecord(lottos.match(this.winningLotto));
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
