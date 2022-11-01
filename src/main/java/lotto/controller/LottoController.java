package lotto.controller;

import lotto.domain.LottoCoin;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class LottoController {

    public void run() {
        LottoCoin lottoCoin = LottoInput.inputMoneyAndAvailableToPurchaseCoin();
        LottoCoin manuallyLottoCoin = LottoInput.inputBuyManuallyNumber(lottoCoin);

        Lottos manuallyLottos = LottoInput.inputManuallyLottos(manuallyLottoCoin);
        LottoOutput.printLottoCount(lottoCoin.size());

        Lottos lottos = Lottos.autoGenerateSizeOf(lottoCoin.size() - manuallyLottoCoin.size());
        LottoOutput.printLottos(lottos);

        WinningLotto winningLotto = LottoInput.inputWinningLotto();
        LottoOutput.printStatistics(winningLotto, lottos);
    }

}
