package lotto.controller;

import lotto.domain.LottoCalculator;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class LottoController {

    public void run() {
        int lottoCount = LottoCalculator.availableToPurchaseCount(LottoInput.inputMoney());
        LottoOutput.printLottoCount(lottoCount);

        Lottos lottos = Lottos.autoGenerateSizeOf(lottoCount);
        lottos.print();

        WinningLotto winningLotto = LottoInput.inputWinningLotto();
        LottoOutput.printStatistics(winningLotto, lottos);
    }

}
