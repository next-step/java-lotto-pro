package Lotto;

import Lotto.utils.InputView;
import Lotto.utils.ResultView;

public class LottoGame {
    public LottoGame() {
    }

    public void calculation() {
        Player player = new Player(InputView.inputMoney());
        player.drawManualAndRemainAuto(InputView.inputManualLottoCount());
        ResultView.printPurchaseLottos(player);

        WinLotto winLotto = setUpWinLotto();
        LottoResult result = player.getTotalLottos().calculation(winLotto);
        ResultView.result(result);
    }

    private WinLotto setUpWinLotto(){
        WinLotto winLotto = new WinLotto();
        winLotto.getLotto().generate(InputView.inputLastWinNumber());
        winLotto.generateBonus(InputView.inputLastWinBonusNumber());
        return winLotto;
    }
}
