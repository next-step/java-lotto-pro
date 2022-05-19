package step3.domain;

import java.util.ArrayList;
import java.util.List;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoGame {
    private static final int PRICE_LOTTO = 1_000;

    public void play() {
        int inputMoney = InputView.inputMoney();
        int buyCount = buyCount(inputMoney);

        Lottos lottos = new Lottos(buy(buyCount));
        OutputView.printLottos(lottos);

        List<Integer> winnerNumbers = InputView.inputWinnerNumbers();
        LottoResult lottoResult = lottos.allMatch(winnerNumbers);
        double yield = lottoResult.calculateYield(investmentAmount(buyCount));
        OutputView.printResult(lottoResult, yield);
    }

    public static int buyCount(int money) {
        return money / PRICE_LOTTO;
    }

    private List<Lotto> buy(int buyCount) {
        OutputView.printBuyCount(buyCount);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            lottos.add(LottoFactory.createAutoLotto());
        }
        return lottos;
    }

    int investmentAmount(int buyCount) {
        return buyCount * PRICE_LOTTO;
    }
}
