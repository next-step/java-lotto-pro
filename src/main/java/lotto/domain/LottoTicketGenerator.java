package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketGenerator {

	private static final List<LottoNumber> CANDIDATES = new ArrayList<>();

	static {
		for (int i = LottoNumber.LOTTO_NUMBER_MINIMUM; i <= LottoNumber.LOTTO_NUMBER_MAXIMUM; i++) {
			CANDIDATES.add(LottoNumber.of(i));
		}
	}

	public static LottoTickets generateByCount(PositiveNumber count) {
		List<LottoTicket> lottoTickets = IntStream.range(0, count.toInt())
			.mapToObj(i -> generate())
			.collect(Collectors.toList());
		return LottoTickets.of(lottoTickets);

	}

	private static LottoTicket generate() {
		Collections.shuffle(CANDIDATES);
		Set<LottoNumber> numbers = new HashSet<>(CANDIDATES.subList(0, LottoNumber.LOTTO_NUMBER_SIZE));
		return LottoTicket.of(numbers);
	}

}
