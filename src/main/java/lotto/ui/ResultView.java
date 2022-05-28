package lotto.ui;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoConst;
import lotto.domain.LottoNo;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinRanks;

public class ResultView {
    static final String PRINT_PURCHASE_COUNT_MESSAGE_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    static final String PRINT_PROFIT_RATE_MESSAGE_FORMAT = "총 수익률은 %.2f 입니다.";
    static final String PRINT_RATE_MATCH_MESSAGE_FORMAT = "%d개 일치 (%d원)-  %d개";
    static final String PRINT_SEPERATOR = "-----------";
    static final String PRINT_LOSS_INFO = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    static final String PRINT_RANK_START_MESSAGE = "당첨 통계";
    static final String LOTTO_PRINT_START_CHAR = "[";
    static final String LOTTO_PRINT_END_CHAR = "]";
    static final String LOTTO_PRINT_DELIMITER = ", ";

    public static void printLottoPurchase(Lottos lottos, int manualCount, int autoCount) {
        String purchaseResultMessage = String.format(PRINT_PURCHASE_COUNT_MESSAGE_FORMAT, manualCount, autoCount);
        System.out.println(purchaseResultMessage);
        for (Lotto lotto : lottos.getLottoSheets()) {
            printLotto(lotto);
        }
    }

    public static void printLottoResult(Lottos lottos, Lotto winningLotto, WinRanks winRanks) {
        System.out.println(PRINT_RANK_START_MESSAGE);
        System.out.println(PRINT_SEPERATOR);

        printRanks(winRanks);
    }

    public static void printProfit(double profitRate) {
        String profitRateFormatted = String.format(PRINT_PROFIT_RATE_MESSAGE_FORMAT, profitRate);
        System.out.println(profitRateFormatted);

        if (profitRate < 1) {
            System.out.println(PRINT_LOSS_INFO);
        }
    }

    public static void printLotto(Lotto lotto) {
        System.out.print(LOTTO_PRINT_START_CHAR);

        List<LottoNo> lottoNumbers = lotto.getLottoNumbers();
        for (int i = 0; i < LottoConst.LOTTO_NO_SIZE - 1; i++) {
            System.out.print(lottoNumbers.get(i));
            System.out.print(LOTTO_PRINT_DELIMITER);
        }

        System.out.print(lottoNumbers.get(LottoConst.LOTTO_NO_SIZE - 1));
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

        String profitRateFormatted = String.format(PRINT_RATE_MATCH_MESSAGE_FORMAT, key, price, count);
        System.out.println(profitRateFormatted);
    }
}