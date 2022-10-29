package step3.view;

import step3.model.Lotto;
import step3.model.Lottos;

import static step3.constant.Message.PURCHASED_LOTTO_TOTAL_COUNT_OUTPUT_MESSAGE;

public class OutputView {
    public static void outputPurchasedLotto(Lottos lottos) {
        printPurchasedCount(lottos);
        printGeneratedLotto(lottos);

    }

    private static void printPurchasedCount(Lottos lottos) {
        System.out.printf(PURCHASED_LOTTO_TOTAL_COUNT_OUTPUT_MESSAGE, lottos.getPurchasedCount());
    }
    private static void printGeneratedLotto(Lottos lottos) {
        for(Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
