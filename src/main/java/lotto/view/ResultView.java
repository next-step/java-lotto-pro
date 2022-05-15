package lotto.view;

import lotto.Lottos;

public class ResultView {

    public static void printPurchaseCount(Lottos lottos) {
        System.out.println(lottos.count() + "개를 구매했습니다.");
    }
}
