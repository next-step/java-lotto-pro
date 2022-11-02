package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMarket {
    private static final Money TICKET_PRICE = new Money(1_000L);

    private LottoMarket() {}

    public static List<LottoTicket> sell(Money money, LottoGenerator lottoGenerator) {
        return make(lottoGenerator, getLottoAmount(money));
    }

    private static Quantity getLottoAmount(Money money) {
        return new Quantity((int) money.divide(TICKET_PRICE));
    }

    private static List<LottoTicket> make(LottoGenerator lottoGenerator, Quantity quantity) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (long i = 0; i < quantity.value(); i++) {
            tickets.add(lottoGenerator.create());
        }

        return tickets;
    }
}
