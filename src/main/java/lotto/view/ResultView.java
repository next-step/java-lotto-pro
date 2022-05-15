package lotto.view;

import lotto.Lotto;
import lotto.Lottos;

import java.util.Collections;

public class ResultView {

    public static void printPurchaseCount(Lottos lottos) {
        System.out.println(lottos.count() + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            Collections.sort(lotto.getLotto());
            System.out.println(lotto.getLotto());
        }
    }
}
