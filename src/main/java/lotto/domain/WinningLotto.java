package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lotto.util.InputSplitter;

public class WinningLotto {
	private final Lotto winLotto;

	public WinningLotto(List<Integer> winNumbers) {
		this.winLotto = new Lotto(winNumbers);
	}

	public WinningLotto(String input) {
		this(convertInputToIntegerList(input));
	}

	private static List<Integer> convertInputToIntegerList(String input) {
		return InputSplitter.splitText(input).stream()
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		WinningLotto that = (WinningLotto)o;
		return Objects.equals(winLotto, that.winLotto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(winLotto);
	}
}
