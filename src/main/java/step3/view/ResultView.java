package step3.view;

import step3.domain.LottoQuantity;

public class ResultView {

    public static void printLottoQuantityMessage(LottoQuantity lottoQuantity) {
        System.out.printf("%d개를 구매했습니다.\n", lottoQuantity.getQuantity());
    }
}
