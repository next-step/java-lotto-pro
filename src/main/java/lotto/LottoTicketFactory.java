package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketFactory {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public static LottoTickets createRandomLottoTickets(LottoCount lottoCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; lottoCount.isBiggerThan(i); i++) {
            lottoTickets.add(createRandomLottoTicket());
        }

        return new LottoTickets(lottoTickets);
    }

    private static LottoTicket createRandomLottoTicket() {
        List<Integer> possibleNumbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());

        Collections.shuffle(possibleNumbers);

        return new LottoTicket(possibleNumbers.stream()
            .limit(LOTTO_SIZE)
            .sorted()
            .collect(Collectors.toList()));
    }
}
