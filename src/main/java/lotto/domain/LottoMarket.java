package lotto.domain;

import lotto.util.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMarket {
    private static final int TICKET_PRICE = 1_000;

    public static List<LottoTicket> sell(int money, LottoGenerator lottoGenerator) {
        return make(lottoGenerator, getLottoAmount(money));
    }

    private static int getLottoAmount(int money) {
        return money / TICKET_PRICE;
    }

    private static List<LottoTicket> make(LottoGenerator lottoGenerator, int amount) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            tickets.add(lottoGenerator.create());
        }

        return tickets;
    }
}
