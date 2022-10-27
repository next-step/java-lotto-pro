package lotto.domain;

import java.util.List;

public class LottoStore {
    private final int lottoFee;
    private final LottoMachine machine;
    public LottoStore(LottoMachine machine, Money lottoFee) {
        this.lottoFee = lottoFee.getValue();
        this.machine = machine;
    }

    public LottoBundle buyLotto(Money money) {
        int lottoTicketCount = money.getValue() / lottoFee;
        List<Lotto> autoLottoList = machine.auto(lottoTicketCount);
        return new LottoBundle(autoLottoList);
    }
}
