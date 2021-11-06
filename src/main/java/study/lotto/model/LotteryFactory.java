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

    public TicketLotteryBundle generateTicketLotteryByCount(final int count) {
        final List<TicketLottery> ticketLotteries = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ticketLotteries.add(generateTicketLottery());
        }
        return TicketLotteryBundle.valueOf(ticketLotteries);
    }

    public TicketLottery generateTicketLottery() {
        final Set<LottoNumber> lottoNumbers = LottoRandoms.getLottoRandomNumbers();
        return TicketLottery.valueOf(lottoNumbers);
    }

    public WinningLottery generateWinningLottery() {
        final Set<LottoNumber> lottoNumbers = LottoRandoms.getLottoRandomNumbers();
        return WinningLottery.valueOf(lottoNumbers);
    }
}
