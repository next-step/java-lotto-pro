package lotto.service;

import lotto.model.LottoGenerator;
import lotto.model.LottoNumbers;
import lotto.model.LottoPrizeRanks;
import lotto.model.LottoQuantityChecker;
import lotto.model.LottoStatics;
import lotto.model.Money;
import lotto.model.PassiveQuantity;
import lotto.model.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMachine {
    public void pay() {
        Money money = new Money(InputView.inputPrice());
        PassiveQuantity passiveQuantity = new PassiveQuantity(InputView.inputPassiveQuantity());
        List<LottoNumbers> passiveNumbers = LottoNumbers.toList(InputView.inputPassiveNumbers(passiveQuantity));

        int quantity = LottoQuantityChecker.calculate(money);
        ResultView.quantity(passiveQuantity, quantity);

        List<LottoNumbers> lottoNumbers = RandomNumberGenerator.generate(quantity);
        addPassiveNumbers(lottoNumbers, passiveNumbers);
        ResultView.table(lottoNumbers);

        List<Integer> winNumbers = LottoGenerator.generateNumbers(InputView.inputLottoNumbers());
        int bonusNumber = LottoGenerator.generateNumber(InputView.inputBonusNumber());

        LottoStatics lottoStatics = new LottoStatics(lottoNumbers, winNumbers, bonusNumber);
        LottoPrizeRanks lottoPrizeRanks = lottoStatics.collect();
        ResultView.showStatics(lottoPrizeRanks);
        ResultView.showRatio(calculateRatio(money, lottoPrizeRanks));
    }

    private void addPassiveNumbers(List<LottoNumbers> lottoNumbers, List<LottoNumbers> passiveNumbers) {
        lottoNumbers.addAll(passiveNumbers);
    }

    private float calculateRatio(Money money, LottoPrizeRanks lottoPrizeRanks) {
        return lottoPrizeRanks.calculate() / money.getMoney();
    }
}
