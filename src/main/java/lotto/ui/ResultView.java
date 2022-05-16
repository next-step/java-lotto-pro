package lotto.ui;

import java.util.Map;
import lotto.Lotto;
import lotto.Lottos;
import lotto.Rank;

public class ResultView {
    static final String PRINT_PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";

    public static void printLottoPurchase(Lottos lottos) {
        System.out.println(lottos.getLottosSize() + PRINT_PURCHASE_COUNT_MESSAGE);
        lottos.printLottos();
    }

    public static void printLottoResult(Lottos lottos, Lotto winningLotto){
        System.out.println("당첨 통계");
        System.out.println("-----------");
        Map<Integer, Rank> winPriceMap = lottos.calculateWinPriceMap(winningLotto);
        lottos.printRanks(winPriceMap);
    }
}
