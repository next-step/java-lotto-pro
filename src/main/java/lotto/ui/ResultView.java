package lotto.ui;

import java.util.Map;
import lotto.Lotto;
import lotto.Lottos;
import lotto.Rank;

public class ResultView {
    static final String PRINT_PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";
    static final String PRINT_SEPERATOR = "-----------";
    static final String PRINT_LOSS_INFO = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    static final String PRINT_RANK_START_MESSAGE = "당첨 통계";
    static final String PROFIT_RATE_FORMAT = "%.2f";

    public static void printLottoPurchase(Lottos lottos) {
        System.out.println(lottos.getLottosSize() + PRINT_PURCHASE_COUNT_MESSAGE);
        lottos.printLottos();
    }

    public static void printLottoResult(Lottos lottos, Lotto winningLotto) {
        System.out.println(PRINT_RANK_START_MESSAGE);
        System.out.println(PRINT_SEPERATOR);
        Map<Integer, Rank> winPriceMap = lottos.calculateWinPriceMap(winningLotto);
        lottos.printRanks(winPriceMap);
    }

    public static double printProfit(int purchaseMoney, int profitMoney) {
        String profitRate = String.format(PROFIT_RATE_FORMAT, (double) profitMoney / purchaseMoney);
        System.out.println("총 수익률은 " + profitRate + " 입니다.");

        if (Double.parseDouble(profitRate) < 1) {
            System.out.println(PRINT_LOSS_INFO);
        }

        return Double.parseDouble(profitRate);
    }
}
