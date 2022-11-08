package study.step3.controller;

import study.step3.domain.lotto.LottoMachine;
import study.step3.domain.lotto.Lottos;
import study.step3.domain.lotto.PurchaseMoney;
import study.step3.domain.lottonumber.LottoNumbers;

import java.util.List;

public class LottoMachineController {

    public Lottos issueLottos(PurchaseMoney purchaseMoney, List<LottoNumbers> lottoNumbers) {
        LottoMachine lottoMachine = new LottoMachine();
        Lottos lottos = lottoMachine.issueManualLottos(lottoNumbers);

        long numberOfRandomLottos = purchaseMoney.numberOfRandomLottos(lottoNumbers.size());
        Lottos randomLottos = lottoMachine.issueRandomLottos(numberOfRandomLottos);
        lottos.addLottos(randomLottos);
        return lottos;
    }
}
