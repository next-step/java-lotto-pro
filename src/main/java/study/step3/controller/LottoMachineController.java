package study.step3.controller;

import study.step3.domain.lotto.LottoIssuanceStrategy;
import study.step3.domain.lotto.LottoMachine;
import study.step3.domain.lotto.Lottos;
import study.step3.domain.lotto.PurchaseMoney;

public class LottoMachineController {

    private final LottoIssuanceStrategy lottoIssuanceStrategy;

    public LottoMachineController(LottoIssuanceStrategy lottoIssuanceStrategy) {
        this.lottoIssuanceStrategy = lottoIssuanceStrategy;
    }

    public Lottos issueLottos(PurchaseMoney purchaseMoney) {
        LottoMachine lottoMachine = new LottoMachine(purchaseMoney, lottoIssuanceStrategy);
        return lottoMachine.issueLottos();
    }
}
