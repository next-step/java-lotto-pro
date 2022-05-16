package Lotto;

import Lotto.utils.InputView;
import Lotto.utils.ResultView;

public class LottoGame {
    public LottoGame() {

    }

    public void calculation() {
        Lottos lottos = purchaseLottos();
        Lotto winLotto = setUpWinLotto();
        LottoResult result = lottos.calculation(winLotto);
        ResultView.result(result);
    }

    private Lottos purchaseLottos() {
        Lottos lottos = new Lottos(InputView.inputMoney());
        ResultView.printPurchaseLottos(lottos);
        return lottos;
    }

    private Lotto setUpWinLotto(){
        Lotto winLotto = new Lotto(InputView.inputLastWinNumber());
        return winLotto;
    }
}
