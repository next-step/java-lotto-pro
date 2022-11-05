package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;

import lotto.util.InputSplitter;

public class InputLottoGenerator implements LottoGenerator {
	private final List<Integer> numbers;

	public InputLottoGenerator(String input) {
		this.numbers = convertInputToIntegerList(input);
	}

	private static List<Integer> convertInputToIntegerList(String input) {
		return InputSplitter.splitText(input).stream()
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	@Override
	public Lotto generate() {
		return Lotto.from(numbers);
	}
}
