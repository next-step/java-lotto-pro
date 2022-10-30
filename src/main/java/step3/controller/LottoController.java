package step3.controller;

import java.util.List;
import step3.domain.LottoStore;
import step3.domain.Lottos;
import step3.domain.UniqueNumbers;
import step3.domain.Money;
import step3.domain.Rank;
import step3.domain.Reward;
import step3.io.InputView;
import step3.io.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    private final LottoStore lottoStore;

    public LottoController(InputView inputView, OutputView outputView, LottoStore lottoStore) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoStore = lottoStore;
    }

    public void start() {
        Money payment = payment();
        Lottos lottos = purchase(payment);
        UniqueNumbers winningNumbers = UniqueNumbers.generate(inputView.inputNumbers());
        int bonusNumber = inputView.inputBonusNumber();
        List<Rank> ranks = lottos.getRanks(winningNumbers, bonusNumber);
        Reward reward = Reward.generate(ranks);
        result(payment, reward);
    }

    private Money payment() {
        Money payment = Money.generate(inputView.inputPayment());
        outputView.printPurchaseCount(payment, LottoStore.pricePerLotto);
        return payment;
    }

    private Lottos purchase(Money payment) {
        Lottos lottos = lottoStore.sell(payment);
        outputView.printLottoNumbers(lottos);
        return lottos;
    }

    private void result(Money payment, Reward reward) {
        outputView.printResultHeader();
        outputView.printStatistics(reward);
        outputView.printWinningMoneyRate(payment, reward);
    }
}
