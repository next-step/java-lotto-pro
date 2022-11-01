package lotto.view;

import lotto.domain.Lottos;

public class ResultView {

    public static void printPurchsedlottoCnt(Lottos lottos) {
        System.out.println(lottos.getLottosSize() + Messages.NOTIFY_PURCHASES.getMsg());
    }

}
