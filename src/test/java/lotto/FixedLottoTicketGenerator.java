package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketGenerator;

public class FixedLottoTicketGenerator implements LottoTicketGenerator {

	private final List<Integer> numbers;

	public FixedLottoTicketGenerator(int... numbers) {
		this(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
	}

	public FixedLottoTicketGenerator(List<Integer> numbers) {
		this.numbers = numbers;
	}

	@Override
	public LottoTicket generate() {
		return LottoTicket.of(
			numbers.stream()
				.mapToInt(Integer::intValue)
				.toArray());
	}
}
