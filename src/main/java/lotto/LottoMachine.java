package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMachine {
    public void pay() {
        String price = InputView.inputPrice();

        int quantity = LottoQuantityChecker.check(price);
        ResultView.quantity(quantity);

        List<LottoNumbers> lottoNumbers = RandomNumberGenerator.generate(quantity);
        ResultView.table(lottoNumbers);

        List<Integer> winNumbers = LottoGenerator.generate(InputView.inputLottoNumbers());
        LottoStatics lottoStatics = new LottoStatics(lottoNumbers, winNumbers);
        LottoPrizeRanks lottoPrizeRanks = lottoStatics.collect();
        ResultView.statics(lottoPrizeRanks);
        ResultView.ratio(calculateRatio(price, lottoPrizeRanks));
    }

    private float calculateRatio(String price, LottoPrizeRanks lottoPrizeRanks) {
        return lottoPrizeRanks.calculate() / Integer.parseInt(price);
    }
}
