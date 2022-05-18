package Lotto;

import Lotto.utils.InputView;
import Lotto.utils.ResultView;

public class LottoGame {
    public LottoGame() {
    }

    public void calculation() {
        Lottos lottos = purchaseLottos();
        WinLotto winLotto = setUpWinLotto();
        LottoResult result = lottos.calculation(winLotto);
        ResultView.result(result);
    }

    private Lottos purchaseLottos() {
        Lottos lottos = new Lottos(InputView.inputMoney());
        ResultView.printPurchaseLottos(lottos);
        return lottos;
    }

    private WinLotto setUpWinLotto(){
        WinLotto winLotto = new WinLotto();
        winLotto.getLotto().generate(InputView.inputLastWinNumber());
        winLotto.generateBonus(InputView.inputLastWinBonusNumber());
        return winLotto;
    }
}
