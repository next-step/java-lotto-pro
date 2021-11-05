package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class ResultView {
    private static final String NOTICE_BUY_QUANTITY = "개를 구매했습니다.";

    public void printBuyMessage(int quantity) {
        System.out.println(quantity + NOTICE_BUY_QUANTITY);
    }
    
    public void printLottoList(Lottos lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

}
