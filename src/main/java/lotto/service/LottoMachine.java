package lotto.service;

import lotto.model.LottoGenerator;
import lotto.model.LottoNumbers;
import lotto.model.LottoPrizeRanks;
import lotto.model.LottoQuantityChecker;
import lotto.model.LottoStatics;
import lotto.model.Money;
import lotto.model.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMachine {
    public void pay() {
        Money money = new Money(InputView.inputPrice());

        int quantity = LottoQuantityChecker.calculate(money);
        ResultView.quantity(quantity);

        List<LottoNumbers> lottoNumbers = RandomNumberGenerator.generate(quantity);
        ResultView.table(lottoNumbers);

        List<Integer> winNumbers = LottoGenerator.generateNumbers(InputView.inputLottoNumbers());
        int bonusNumber = LottoGenerator.generateNumber(InputView.inputBonusNumber());

        LottoStatics lottoStatics = new LottoStatics(lottoNumbers, winNumbers, bonusNumber);
        LottoPrizeRanks lottoPrizeRanks = lottoStatics.collect();
        ResultView.statics(lottoPrizeRanks);
        ResultView.showRatio(calculateRatio(money, lottoPrizeRanks));
    }

    private float calculateRatio(Money money, LottoPrizeRanks lottoPrizeRanks) {
        return lottoPrizeRanks.calculate() / money.getMoney();
    }
}
