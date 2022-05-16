package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApp {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        int money = InputView.inputMoney();
        List<Lotto> lottos = lottoMachine.purchase(money);
        OutputView.outputLottos(lottos);

        List<Integer> numbers = InputView.inputWinningLotto();
        int bonus = InputView.inputBonusNumber();
        WinLotto winLotto = new WinLotto(numbers, bonus);

        Statistics statistics = new Statistics(winLotto, lottos);
        OutputView.outputResult(statistics.getResultMap());
        OutputView.outputResultProfit(statistics.getProfit());
    }
}
