package lotto;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.Statistics;
import lotto.model.WinLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApp {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        List<List<Integer>> manualLottoNumbers = InputView.inputManualLottoNumbers();
        List<Lotto> manualLottos = lottoMachine.purchaseManual(manualLottoNumbers);

        int money = InputView.inputMoney();
        List<Lotto> autoLottos = lottoMachine.purchaseAuto(money);
        OutputView.outputLottos(manualLottos, autoLottos);

        List<Integer> numbers = InputView.inputWinningLotto();
        int bonus = InputView.inputBonusNumber();
        WinLotto winLotto = new WinLotto(numbers, bonus);

        Statistics statistics = new Statistics(winLotto, autoLottos, manualLottos);
        OutputView.outputResult(statistics.getResultMap());
        OutputView.outputResultProfit(statistics.getProfit());
    }
}
