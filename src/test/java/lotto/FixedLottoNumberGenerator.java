package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixedLottoNumberGenerator implements LottoNumberGenerator {

	private final List<Integer> numbers;

	public FixedLottoNumberGenerator(int... numbers) {
		this.numbers = Arrays.stream(numbers).boxed().collect(Collectors.toList());
	}

	@Override
	public LottoTicket generate() {
		return LottoTicket.of(
			numbers.stream()
				.mapToInt(Integer::intValue)
				.toArray());
	}
}
