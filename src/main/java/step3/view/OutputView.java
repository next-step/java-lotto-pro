package step3.view;

import step3.model.Lotto;
import step3.model.LottoCalculator;
import step3.model.Lottos;

import static step3.constant.Message.*;
import static step3.constant.Constant.*;

public class OutputView {
    public static void outputPurchasedLotto(Lottos lottos) {
        printPurchasedCount(lottos);
        printGeneratedLotto(lottos);
    }

    public static void outputStatisticsResult(LottoCalculator calculator) {
        printStatisticsNotice();
        printLottoResult(calculator);
    }

    private static void printLottoResult(LottoCalculator calculator) {
        for(int i = MIN_WINNER_NUMBER; i <= MAX_WINNER_NUMBER; i++) {
            System.out.println(calculator.createResultMessage(i));
        }
    }

    private static void printPurchasedCount(Lottos lottos) {
        System.out.printf(PURCHASED_LOTTO_TOTAL_COUNT_OUTPUT_MESSAGE, lottos.getPurchasedCount());
    }
    private static void printGeneratedLotto(Lottos lottos) {
        for(Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static void printStatisticsNotice() {
        System.out.println(WINNER_STATISTICS);
        System.out.println(SPLIT_LINE);
    }

}
