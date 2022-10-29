package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.util.InputSplitter;

public class WinNumbers {
	private final Set<LottoNumber> winNumbers;

	public WinNumbers(List<Integer> winNumbers) {
		this.winNumbers = winNumbers.stream()
			.map(LottoNumber::new)
			.collect(Collectors.toSet());
	}

	public WinNumbers(String input) {
		this(convertInputToIntegerList(input));
	}

	private static List<Integer> convertInputToIntegerList(String input) {
		return InputSplitter.splitText(input).stream()
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	public int countMatches(Lotto lotto) {
		return (int)winNumbers.stream()
			.filter(lotto::contains)
			.count();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		WinNumbers that = (WinNumbers)o;
		return Objects.equals(winNumbers, that.winNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(winNumbers);
	}

}
