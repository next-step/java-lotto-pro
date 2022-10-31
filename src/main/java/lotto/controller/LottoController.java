package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class LottoController {

    public void run() {
        int lottoCount = LottoInput.inputMoneyAndAvailableToPurchaseCount();
        LottoOutput.printLottoCount(lottoCount);

        Lottos lottos = Lottos.autoGenerateSizeOf(lottoCount);
        LottoOutput.printLottos(lottos);

        WinningLotto winningLotto = LottoInput.inputWinningLotto();
        LottoOutput.printStatistics(winningLotto, lottos);
    }

}
