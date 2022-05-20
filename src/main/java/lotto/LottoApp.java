package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApp {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        int count = InputView.inputManualLottoCount();
        List<List<Integer>> manualLottoNumbers = InputView.inputManualLottoNumbers(new LottoCount(count));
        List<Lotto> manualLottos = lottoMachine.purchaseManual(manualLottoNumbers);

        int money = InputView.inputMoney();
        List<Lotto> autoLottos = lottoMachine.purchaseAuto(money);
        OutputView.outputLottos(manualLottos, autoLottos);

        List<Integer> numbers = InputView.inputWinningLotto();
        int bonus = InputView.inputBonusNumber();
        WinLotto winLotto = new WinLotto(numbers, bonus);

        Statistics statistics = new Statistics();
        OutputView.outputResult(statistics.culculate(winLotto, autoLottos, manualLottos));
        OutputView.outputResultProfit(statistics.getProfit());
    }
}
