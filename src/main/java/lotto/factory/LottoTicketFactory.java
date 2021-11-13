package lotto.factory;

import static lotto.domain.LottoNumber.*;
import static lotto.domain.LottoTicket.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.LottoCount;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class LottoTicketFactory {
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
            .collect(Collectors.toList()));
    }
}
