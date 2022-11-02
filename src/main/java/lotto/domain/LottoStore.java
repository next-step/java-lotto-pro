package lotto.domain;

import java.util.List;

public class LottoStore {
    private final static int LOTTO_FEE = 1000;
    private final LottoMachine machine;

    public LottoStore(LottoMachine machine) {
        this.machine = machine;
    }

    public LottoBundle buyAutoLotto(Money money) {
        int lottoTicketCount = money.calLottoTicketCount(LOTTO_FEE);
        List<Lotto> newMultiLottoList = machine.getNewMultiLottoList(lottoTicketCount);
        return new LottoBundle(newMultiLottoList);
    }

    public LottoBundle buyAutoLotto(Money money, int manualLottoTicketCount) {
        Money remain = money.minus(manualLottoTicketCount * LOTTO_FEE);
        int lottoTicketCount = remain.calLottoTicketCount(LOTTO_FEE);
        List<Lotto> newLottoList = machine.getNewMultiLottoList(lottoTicketCount);
        return new LottoBundle(newLottoList);
    }
}
