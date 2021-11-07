package lotto2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicketGenerator {

	private static final List<LottoNumber> candidates = new ArrayList<>();

	static {
		for (int i = LottoNumber.LOTTO_NUMBER_MINIMUM; i <= LottoNumber.LOTTO_NUMBER_MAXIMUM; i++) {
			candidates.add(LottoNumber.of(i));
		}
	}

	public static LottoTickets generateByCount(PositiveNumber count) {
		LottoTickets tickets = LottoTickets.of();
		for (int i = 0; i < count.toInt(); i++) {
			tickets.add(generate());
		}
		return tickets;
	}

	private static LottoTicket generate() {
		Collections.shuffle(candidates);
		Set<LottoNumber> numbers = new HashSet<>(candidates.subList(0, lotto.domain.LottoNumber.LOTTO_NUMBER_SIZE));
		return LottoTicket.of(numbers);
	}

}
