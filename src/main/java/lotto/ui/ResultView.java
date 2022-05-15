package lotto.ui;

import lotto.Lottos;

public class ResultView {
    static final String PRINT_PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";

    public static void printLottoPurchase(Lottos lottos) {
        System.out.println(lottos.getLottosSize() + PRINT_PURCHASE_COUNT_MESSAGE);
        lottos.printLottos();
    }
}
