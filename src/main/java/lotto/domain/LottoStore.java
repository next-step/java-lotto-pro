package lotto.domain;

import java.util.List;

public class LottoStore {
    private final static int LOTTO_FEE = 1000;
    private final LottoMachine machine;
    public LottoStore(LottoMachine machine) {
        this.machine = machine;
    }

    public LottoBundle buyLotto(Money money) {
        int lottoTicketCount = money.calLottoTicketCount(LOTTO_FEE);
        List<Lotto> autoLottoList = machine.auto(lottoTicketCount);
        return new LottoBundle(autoLottoList);
    }
}
