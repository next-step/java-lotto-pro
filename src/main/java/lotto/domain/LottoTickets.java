package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private static final List<Integer> LOTTO_NUMBER_CANDIDATES = IntStream.range(LottoNumbers.MINIMUM_NUMBER, LottoNumbers.MAXIMUM_NUMBER + 1)
            .boxed()
            .collect(Collectors.toList());

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(final int amountOfTickets) {
        lottoTickets = new ArrayList<>();
        for (int i = 0; i < amountOfTickets; i++){
//            lottoTickets.add(createTicketAutomatically());
        }
    }

//    private static LottoNumbers createTicketAutomatically() {
//        Collections.shuffle(LOTTO_NUMBER_CANDIDATES);
//        List<Integer> numbers = new ArrayList<>(LOTTO_NUMBER_CANDIDATES.subList(0, LottoNumbers.AMOUNT_OF_NUMBERS));
//        Collections.sort(numbers);
//        return new LottoNumbers(numbers);
//    }

    @Override
    public String toString() {
        return "LottoTickets{" +
                "lottoTickets=" + lottoTickets +
                '}';
    }
}
