package step3.controller;

import java.util.List;
import step3.utils.CriteriaProvider;
import step3.domain.LottoStore;
import step3.domain.Lottos;
import step3.domain.Numbers;
import step3.domain.Money;
import step3.domain.Reward;
import step3.io.InputView;
import step3.io.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    private final LottoStore lottoStore;
    private final CriteriaProvider criteriaProvider;

    public LottoController(InputView inputView, OutputView outputView, LottoStore lottoStore, CriteriaProvider criteriaProvider) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoStore = lottoStore;
        this.criteriaProvider = criteriaProvider;
    }

    public void start() {
        Money payment = payment();
        Lottos lottos = purchase(payment);
        Numbers winningNumbers = Numbers.generate(inputView.inputNumbers());
        List<Integer> matchCounts = lottos.getMatchCounts(winningNumbers);
        Reward reward = Reward.generate(matchCounts, criteriaProvider);
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
        outputView.printStatistics(reward.getStatistics());
        outputView.printWinningMoneyRate(reward.getWinningMoneyRate(payment));
    }
}
