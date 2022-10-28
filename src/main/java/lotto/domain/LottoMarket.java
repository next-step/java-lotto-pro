package lotto.domain;

import lotto.util.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMarket {
    private static final Money TICKET_PRICE = new Money(1_000L);

    public static List<LottoTicket> sell(Money money, LottoGenerator lottoGenerator) {
        return make(lottoGenerator, getLottoAmount(money));
    }

    private static long getLottoAmount(Money money) {
        return money.divide(TICKET_PRICE);
    }

    private static List<LottoTicket> make(LottoGenerator lottoGenerator, long amount) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (long i = 0; i < amount; i++) {
            tickets.add(lottoGenerator.create());
        }

        return tickets;
    }
}
