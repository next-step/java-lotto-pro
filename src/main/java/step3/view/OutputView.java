package step3.view;

import step3.constant.Rank;
import step3.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static step3.constant.Message.Output.*;
import static step3.constant.Message.Output.COUNT_UNIT_RESULT_MESSAGE;
import static step3.constant.Message.System.*;

public class OutputView {
    public static void outputPurchasedLotto(LottoGenerator lottoGenerator) {
        printPurchasedCount(lottoGenerator);
        printGeneratedLotto(lottoGenerator.getLottos());
    }

    public static void outputStatisticsResult(LottoCalculator calculator) {
        printStatisticsNotice();
        printLottoResult(calculator);
        printLottoProfitRate(calculator);
    }

    private static void printLottoProfitRate(LottoCalculator calculator) {
        System.out.printf(PROFIT_RATE_RESULT, calculator.calculateProfitRate());
    }

    private static void printLottoResult(LottoCalculator calculator) {
        List<Rank> ranks = Arrays.stream(Rank.rankValues()).filter(r -> r.getCountOfMatch() != 0)
                .collect(Collectors.toList());

        for(Rank rank : ranks) {
            String resultMessage = createResultMessage(rank, calculator.getLottoResult());
            System.out.println(resultMessage);
        }
    }

    private static void printPurchasedCount(LottoGenerator lottoGenerator) {
        int manualCount = lottoGenerator.getManualCount();
        int autoCount = lottoGenerator.getPurchasedCount() - lottoGenerator.getManualCount();
        System.out.printf(PURCHASED_LOTTO_TOTAL_COUNT_OUTPUT_MESSAGE, manualCount, autoCount);
    }

    private static void printGeneratedLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLottoList()) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static void printStatisticsNotice() {
        System.out.println(WINNER_STATISTICS);
        System.out.println(SPLIT_LINE);
    }

    public static String createResultMessage(Rank rank, LottoResult lottoResult) {
        String second = rank == Rank.SECOND ? BONUS_CUSTOM_RESULT_MESSAGE : GENERAL_RESULT_MESSAGE;

        return new StringBuilder(String.valueOf(rank.getCountOfMatch()))
                .append(second)
                .append(rank.getWinningMoney())
                .append(WON_RESULT_MESSAGE)
                .append(lottoResult.getWinningCount(rank))
                .append(COUNT_UNIT_RESULT_MESSAGE).toString();
    }

}
