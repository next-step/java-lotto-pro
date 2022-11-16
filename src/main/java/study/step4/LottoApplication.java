package study.step4;

import study.step4.helper.LottoMaker;
import study.step4.models.*;
import study.step4.views.InputView;
import study.step4.views.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        Money money = new Money(InputView.inputMoney());

        int numberOfManualLotto = InputView.inputNumberOfManualLotto();
        money.validateEnoughToBuyLotto(numberOfManualLotto);

        List<String> manualLottosString = InputView.inputManualLottoNumber(numberOfManualLotto);
        IntegratedLottos integratedLottos = LottoMaker.makeLottos(money.numberAvailable(), manualLottosString);
        ResultView.printIntegratedLottos(integratedLottos);

        Lotto winningLottoNumbers = new Lotto(InputView.inputWinningNumbers());
        LottoNumber bonusBall = new LottoNumber(InputView.inputBonusBall());
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusBall);

        Winners winners = new Winners(integratedLottos.findWinningLottos(winningLotto));
        ResultView.printLottoWinners(winners);
        ResultView.printEarningRate(winners, money);
    }
}
