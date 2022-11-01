package step3.view;

import step3.constant.Rank;
import step3.model.Lotto;
import step3.model.LottoCalculator;
import step3.model.LottoGenerator;
import step3.model.Lottos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static step3.constant.Message.System.*;
import static step3.constant.Constant.Lotto.*;

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
            System.out.println(calculator.createResultMessage(rank));
        }
    }

    private static void printPurchasedCount(LottoGenerator lottoGenerator) {
        System.out.printf(PURCHASED_LOTTO_TOTAL_COUNT_OUTPUT_MESSAGE, lottoGenerator.getPurchasedCount());
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

}
