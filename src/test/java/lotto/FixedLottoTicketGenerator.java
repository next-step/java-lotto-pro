package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixedLottoTicketGenerator implements LottoTicketGenerator {

	private final List<Integer> numbers;

	public FixedLottoTicketGenerator(int... numbers) {
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
