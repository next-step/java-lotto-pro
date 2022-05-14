package lotto;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.Statistics;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApp {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        // 구매금액 입력 & 출력
        int money = InputView.inputMoney();
        List<Lotto> lottos = lottoMachine.purchase(money);
        OutputView.outputLottos(lottos);

        // 지난 당첨 로또 입력
        List<Integer> numbers = InputView.inputWinningLotto();
        Lotto winLotto = new Lotto(numbers);

        // 결과 출력
        Statistics statistics = new Statistics(winLotto, lottos);
        OutputView.outputResult(statistics.getResultMap());
        OutputView.outputResultProfit(statistics.getProfit());
    }
}
