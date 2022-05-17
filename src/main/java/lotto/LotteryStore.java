package lotto;

import lotto.vo.Ticket;
import lotto.vo.Lotteries;
import lotto.vo.Lottery;

import java.util.LinkedList;
import java.util.List;

public class LotteryStore {
    private LotteryStore() {
    }

    public static Lotteries exchangeTicketToLotteries(Ticket ticket) {
        LotteryProducer lotteryProducer = new LotteryProducer();
        List<Lottery> lotteries = new LinkedList<>();
        int size = ticket.size();
        while (size-- > 0) {
            lotteries.add(new Lottery(lotteryProducer.issue()));
        }
        return new Lotteries(lotteries);
    }
}
