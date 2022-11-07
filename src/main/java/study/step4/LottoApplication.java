package study.step4;

import study.step4.helper.LottoMaker;
import study.step4.models.*;
import study.step4.views.InputView;
import study.step4.views.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        Money money = new Money(InputView.inputMoney());

        Lottos lottos = LottoMaker.makeLottos(money);
        ResultView.printLottos(lottos);

        WinningLotto winningLotto = new WinningLotto(InputView.inputWinningNumbers());

        BonusBall bonusBall = new BonusBall(InputView.inputBonusBallNumber());
        bonusBall.validateNotInWinningLotto(winningLotto);
        Winners winners = lottos.findWinners(winningLotto, bonusBall);
        ResultView.printLottoWinners(winners);
        ResultView.printEarningRate(winners, money);
    }
}
