package lotto.service;

import lotto.model.LottoGenerator;
import lotto.model.LottoNumbers;
import lotto.model.LottoPrizeRanks;
import lotto.model.LottoQuantityChecker;
import lotto.model.LottoStatics;
import lotto.model.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMachine {
    public void pay() {
        String price = InputView.inputPrice();

        int quantity = LottoQuantityChecker.calculate(price);
        ResultView.quantity(quantity);

        List<LottoNumbers> lottoNumbers = RandomNumberGenerator.generate(quantity);
        ResultView.table(lottoNumbers);

        List<Integer> winNumbers = LottoGenerator.generate(InputView.inputLottoNumbers());
        LottoStatics lottoStatics = new LottoStatics(lottoNumbers, winNumbers);
        LottoPrizeRanks lottoPrizeRanks = lottoStatics.collect();
        ResultView.statics(lottoPrizeRanks);
        ResultView.showRatio(calculateRatio(price, lottoPrizeRanks));
    }

    private float calculateRatio(String price, LottoPrizeRanks lottoPrizeRanks) {
        return lottoPrizeRanks.calculate() / Integer.parseInt(price);
    }
}
