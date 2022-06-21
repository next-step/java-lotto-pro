package lotto.service;

import lotto.model.Lotteries;
import lotto.model.Lottery;
import lotto.model.Ticket;

import java.util.LinkedList;
import java.util.List;

public class LotteryStore {
    private LotteryStore() {
    }

    public static Lotteries exchangeToLotteries(Ticket ticket) {
        List<Lottery> lotteries = new LinkedList<>();
        int size = ticket.size();
        while (size-- > 0) {
            lotteries.add(new Lottery(LotteryProducer.issue()));
        }
        return new Lotteries(lotteries);
    }
}
