package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;
import lotto.ui.Input;
import lotto.ui.Output;
import lotto.ui.View;

public class LottoGame {

    private final View view;

    public LottoGame(Input input, Output output) {
        this.view = new View(input, output);

    }

    public void run() {
        Lottos lottos = lottoBuyingProcess();
        lottoResultProcess(lottos);
    }

    private Lottos lottoBuyingProcess() {
        Lottos lottos = new Lottos(new RandomNumberPickStrategy());

        Money totalMoney = Money.from(view.insertMoney());
        int manualLottoCount = view.insertManualLottoCount();
        Money manualMoney = Money.fromCount(totalMoney.checkPossibleLottoCount(manualLottoCount));
        Money autoMoney = totalMoney.minus(manualMoney);

        buyManualLottos(lottos, manualLottoCount);
        lottos.buyRandomNumberLottos(autoMoney.availableLottoSize());

        view.printLottoSize(manualMoney.availableLottoSize(), autoMoney.availableLottoSize());

        return lottos;
    }

    private void lottoResultProcess(Lottos lottos) {
        view.printText(lottos.toString());

        List<Integer> winningNumbers = view.insertWinningNumber();
        int bonusNumber = view.insertBonusNumber();

        view.printResultStat(lottos.checkResultStat(new WinningLotto(winningNumbers, bonusNumber)));
    }

    private void buyManualLottos(Lottos lottos, int manualLottoCount) {
        view.printInsertManualLotto();
        IntStream.iterate(0, i -> i + 1)
                .limit(manualLottoCount)
                .forEach(i -> lottos.buyManualLotto(view::insertManualLotto));
    }
}
