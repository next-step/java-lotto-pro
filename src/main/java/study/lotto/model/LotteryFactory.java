package study.lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LotteryFactory {

    private LotteryFactory() {
    }

    public static LotteryFactory getInstance() {
        return new LotteryFactory();
    }

    public TicketLotteryBundle generateTicketLotteryBundleByCount(final TicketOrderCount orderCount) {
        final List<TicketLottery> ticketLotteries = new ArrayList<>();
        orderCount.getStream()
                .forEach(value -> ticketLotteries.add(generateTicketLottery()));
        return TicketLotteryBundle.valueOf(ticketLotteries);
    }

    public TicketLottery generateTicketLottery() {
        final Set<Integer> lottoNumbers = LottoRandoms.getLottoRandomNumbers();
        return TicketLottery.valueOf(lottoNumbers, TicketLotteryType.AUTO);
    }
}
