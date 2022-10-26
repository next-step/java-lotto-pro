package step3.view;

import step3.domain.Lotto;
import step3.domain.LottoQuantity;
import step3.domain.Lottos;

public class ResultView {

    public static void printLottoQuantityMessage(LottoQuantity lottoQuantity) {
        System.out.printf("%d개를 구매했습니다.\n", lottoQuantity.getQuantity());
    }

    public static void printLottosNumberMessage(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
