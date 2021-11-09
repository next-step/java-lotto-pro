package study.lotto.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryFactory {

    private LotteryFactory() {
    }

    public static TicketLotteryBundle generateAutoTicketLotteryBundleByCount(final TicketOrderCount orderCount) {
        final List<TicketLottery> ticketLotteries = orderCount.getStream()
                .mapToObj(index -> generateAutoTicketLottery())
                .collect(Collectors.toList());
        return TicketLotteryBundle.valueOf(ticketLotteries);
    }

    public static TicketLottery generateAutoTicketLottery() {
        final Set<Integer> lottoNumbers = LottoRandoms.getLottoRandomNumbers();
        return TicketLottery.valueOf(lottoNumbers, TicketLotteryType.AUTO);
    }
}
