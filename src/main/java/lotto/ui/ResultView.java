package lotto.ui;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.Lottos;
import lotto.Rank;
import lotto.WinRanks;

public class ResultView {
    static final String PRINT_PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";
    static final String PRINT_SEPERATOR = "-----------";
    static final String PRINT_LOSS_INFO = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    static final String PRINT_RANK_START_MESSAGE = "당첨 통계";
    static final String LOTTO_PRINT_START_CHAR = "[";
    static final String LOTTO_PRINT_END_CHAR = "]";
    static final String LOTTO_PRINT_DELIMITER = ", ";
    static final int LOTTO_COUNT = 6;

    public static void printLottoPurchase(Lottos lottos) {
        System.out.println(lottos.getLottosSize() + PRINT_PURCHASE_COUNT_MESSAGE);
        for (Lotto lotto : lottos.getLottoSheets()) {
            printLotto(lotto);
        }
    }

    public static void printLottoResult(Lottos lottos, Lotto winningLotto) {
        System.out.println(PRINT_RANK_START_MESSAGE);
        System.out.println(PRINT_SEPERATOR);

        WinRanks winRanks = new WinRanks();

        printRanks(winRanks);
    }

    public static void printProfit(String profitRate) {
        System.out.println("총 수익률은 " + profitRate + " 입니다.");

        if (Double.parseDouble(profitRate) < 1) {
            System.out.println(PRINT_LOSS_INFO);
        }
    }

    public static void printLotto(Lotto lotto) {
        System.out.print(LOTTO_PRINT_START_CHAR);

        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        for (int i = 0; i < LOTTO_COUNT - 1; i++) {
            System.out.print(lottoNumbers.get(i));
            System.out.print(LOTTO_PRINT_DELIMITER);
        }

        System.out.print(lottoNumbers.get(LOTTO_COUNT - 1));
        System.out.println(LOTTO_PRINT_END_CHAR);
    }

    private static void printRanks(WinRanks winRanks) {
        Map<Rank, Integer> getWinTotals = winRanks.getWinTotals();
        for (Rank key : getWinTotals.keySet()) {
            printRank(key, getWinTotals.get(key));
        }
    }

    public static void printRank(Rank rank, int count) {
        int key = rank.getCountOfMatch();
        int price = rank.getWinningMoney();
        System.out.println(key + "개 일치 (" + price + "원)- " + count + "개");
    }
}
