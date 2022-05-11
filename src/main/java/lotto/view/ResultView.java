package lotto.view;

import java.util.Arrays;
import lotto.vo.Lotto;
import lotto.vo.Lottos;

public class ResultView {

    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String ENTER = "\n";

    public String resultPurchaseView(Lottos lottos){
        return String.format(PURCHASE_MESSAGE, lottos.getPlayCount());
    }

    public String generatedLottosView(Lottos lottos) {
        StringBuilder totalLottoNumberView = new StringBuilder();
        for (Lotto lotto : lottos.getLottoList()){
            totalLottoNumberView.append(Arrays.toString(lotto.getNumberList().toArray()));
            totalLottoNumberView.append(ENTER);
        }
        return totalLottoNumberView.toString();
    }
}
