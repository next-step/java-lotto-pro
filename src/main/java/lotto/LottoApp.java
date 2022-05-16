package lotto;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoNumber;
import lotto.model.Statistics;
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
        Lotto winLotto = new Lotto(numbers);

        LottoNumber bonus = InputView.inputBonusNumber();

        Statistics statistics = new Statistics(winLotto, bonus, lottos);
        OutputView.outputResult(statistics.getResultMap());
        OutputView.outputResultProfit(statistics.getProfit());
    }
}
