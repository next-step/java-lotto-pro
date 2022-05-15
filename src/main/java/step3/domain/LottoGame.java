package step3.domain;

import java.util.ArrayList;
import java.util.List;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoGame {
    private static final int PRICE_LOTTO = 1000;

    public void play() {
        int inputMoney = InputView.inputMoney();
        int buyCount = buyCount(inputMoney);

        Lottos lottos = new Lottos(buy(buyCount));
        OutputView.printLottos(lottos);

        List<Integer> winnerNumbers = InputView.inputWinnerNumbers();
        LottoResult lottoResult = lottos.allMatch(winnerNumbers);
        lottoResult.calculateYield(investmentAmount(buyCount));
        OutputView.printResult(lottoResult);
    }

    public static int buyCount(int money) {
        return money / PRICE_LOTTO;
    }

    private List<Lotto> buy(int buyCount) {
        System.out.printf("%d개를 구매했습니다.%n", buyCount);
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
