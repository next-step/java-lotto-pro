package lotto.view;

import lotto.vo.Lottos;

public class ResultView {

    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";

    public String resultPurchaseView(Lottos lottos){
        return String.format(PURCHASE_MESSAGE, lottos.getPlayCount());
    }
}
