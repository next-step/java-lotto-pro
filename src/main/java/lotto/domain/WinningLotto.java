package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningLotto {

	private final Lotto winningLotto;

	public WinningLotto(List<Integer> numbers) {
		this.winningLotto = new Lotto(
			numbers.stream()
			.sorted()
			.collect(Collectors.toList()));
	}

	public WinningRecord match(Lottos lottos) {
		return new WinningRecord(lottos.match(winningLotto));
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
