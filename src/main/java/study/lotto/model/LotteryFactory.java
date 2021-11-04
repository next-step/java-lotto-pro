package study.lotto.model;

import java.util.Set;

public class LotteryFactory {

    public TicketLottery generateTicketLottery() {
        final Set<LottoNumber> lottoNumbers = LottoRandoms.getLottoRandomNumbers();
        return TicketLottery.valueOf(lottoNumbers);
    }

    public WinningLottery generateWinningLottery() {
        final Set<LottoNumber> lottoNumbers = LottoRandoms.getLottoRandomNumbers();
        return WinningLottery.valueOf(lottoNumbers);
    }
}
