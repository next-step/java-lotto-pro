package study.lotto.model;

import java.util.Set;

public class TicketLottery extends Lottery {
    private TicketLottery(Set<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public static TicketLottery valueOf(final Set<LottoNumber> lottoNumbers) {
        return new TicketLottery(lottoNumbers);
    }
}
