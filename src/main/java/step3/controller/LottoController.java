package step3.controller;

import java.util.List;
import step3.domain.Lotto;
import step3.domain.Number;
import step3.domain.LottoStore;
import step3.domain.Lottos;
import step3.domain.UniqueNumbers;
import step3.domain.Money;
import step3.domain.Rank;
import step3.domain.Reward;
import step3.io.InputView;
import step3.io.OutputView;

public class LottoController {

    private final LottoStore lottoStore;

    public LottoController(LottoStore lottoStore) {
        this.lottoStore = lottoStore;
    }

    public void start() {
        Money payment = payment();
        int manualCount = manualCount();
        Lottos lottos = purchase(payment, manualCount);
        UniqueNumbers winningNumbers = UniqueNumbers.generate(InputView.inputWinningNumbers());
        Number bonusNumber = InputView.inputBonusNumber();
        List<Rank> ranks = lottos.getRanks(winningNumbers, bonusNumber);
        Reward reward = Reward.generate(ranks);
        result(payment, reward);
    }

    private Money payment() {
        return Money.generate(InputView.inputPayment());
    }

    private int manualCount() {
        return InputView.inputManualCount();
    }

    private Lottos purchase(Money payment, int manualCount) {
        List<Lotto> manualLottos = lottoStore.generateManualLottos(manualCount);
        Lottos lottos = lottoStore.sell(payment, manualLottos);
        int autoCount = payment.divide(LottoStore.pricePerLotto) - manualCount;
        OutputView.printPurchaseCount(autoCount, manualCount);
        OutputView.printLottoNumbers(lottos);
        return lottos;
    }

    private void result(Money payment, Reward reward) {
        OutputView.printResultHeader();
        OutputView.printStatistics(reward);
        OutputView.printWinningMoneyRate(payment, reward);
    }
}
