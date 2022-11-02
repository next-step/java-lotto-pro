package step3.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        List<UniqueNumbers> manualNumberList = generateManualNumberList();
        Lottos lottos = purchase(payment, manualNumberList);
        UniqueNumbers winningNumbers = UniqueNumbers.generate(InputView.inputWinningNumbers());
        Number bonusNumber = InputView.inputBonusNumber();
        List<Rank> ranks = lottos.getRanks(winningNumbers, bonusNumber);
        Reward reward = Reward.generate(ranks);
        result(payment, reward);
    }

    private Money payment() {
        return Money.generate(InputView.inputPayment());
    }

    private Lottos purchase(Money payment, List<UniqueNumbers> manualNumberList) {
        Lottos lottos = lottoStore.sell(payment, manualNumberList);
        int manualCount = manualNumberList.size();
        int autoCount = payment.divide(LottoStore.pricePerLotto) - manualCount;
        OutputView.printPurchaseCount(autoCount, manualCount);
        OutputView.printLottoNumbers(lottos);
        return lottos;
    }

    private List<UniqueNumbers> generateManualNumberList() {
        int manualCount = manualCount();
        if (manualCount == 0) {
            return Collections.emptyList();
        }
        InputView.printInputManualNumbers();
        return generateManualNumberList(manualCount);
    }

    private int manualCount() {
        return InputView.inputManualCount();
    }

    private List<UniqueNumbers> generateManualNumberList(int manualCount) {
        List<UniqueNumbers> uniqueNumbersList = new ArrayList<>();
        for (int count = 0; count < manualCount; count++) {
            List<Number> numbers = InputView.inputManualNumbers();
            UniqueNumbers uniqueNumbers = UniqueNumbers.generate(numbers);
            uniqueNumbersList.add(uniqueNumbers);
        }
        return uniqueNumbersList;
    }

    private void result(Money payment, Reward reward) {
        OutputView.printResultHeader();
        OutputView.printStatistics(reward);
        OutputView.printWinningMoneyRate(payment, reward);
    }
}
