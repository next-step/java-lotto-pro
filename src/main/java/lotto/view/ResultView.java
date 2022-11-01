package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class ResultView {

    public static void printPurchasedlottoCnt(Lottos lottos) {
        System.out.println(lottos.getLottosSize() + Messages.NOTIFY_PURCHASES.getMsg());
    }

    public static void printGeneratedLotto(Lottos lottos) {
        lottos.getLottoList().stream().forEach(lotto -> System.out.println(lotto.getLotto()));
    }

}
