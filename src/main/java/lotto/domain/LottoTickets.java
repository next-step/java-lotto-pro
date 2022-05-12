package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private static final List<Integer> LOTTO_NUMBER_CANDIDATES = IntStream.range(LottoTicket.MINIMUM_NUMBER, LottoTicket.MAXIMUM_NUMBER + 1)
            .boxed()
            .collect(Collectors.toList());

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(final int amountOfTickets) {
        lottoTickets = new ArrayList<>();
        for (int i = 0; i < amountOfTickets; i++){
            lottoTickets.add(createTicketAutomatically());
        }
    }

    private static LottoTicket createTicketAutomatically() {
        Collections.shuffle(LOTTO_NUMBER_CANDIDATES);
        List<Integer> numbers = new ArrayList<>(LOTTO_NUMBER_CANDIDATES.subList(0, LottoTicket.AMOUNT_OF_NUMBERS));
        Collections.sort(numbers);
        return new LottoTicket(numbers);
    }

    @Override
    public String toString() {
        return "LottoTickets{" +
                "lottoTickets=" + lottoTickets +
                '}';
    }
}
