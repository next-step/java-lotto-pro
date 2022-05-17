package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int BASE_INDEX = 0;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final List<Integer> LOTTO_NUMBERS = IntStream
            .rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    public LottoTickets buyLottoTicket(Money money) {
        return createLottoTickets(money.findPurchaseTicketQuantity());
    }

    private LottoTickets createLottoTickets(int ticketQuantity) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketQuantity; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers(generateLottoNumbers());
            lottoTickets.add(new LottoTicket(lottoNumbers));
        }
        return new LottoTickets(lottoTickets);
    }

    private List<LottoNumber> generateLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<LottoNumber> lottoNumbers = LOTTO_NUMBERS.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList())
                .subList(BASE_INDEX, LOTTO_NUMBER_SIZE);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
