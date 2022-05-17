package lotto.view;

import lotto.domain.*;
import lotto.enums.Rank;
import lotto.view.message.dto.MatchResultParameters;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lotto.view.message.ResultMessage.*;

public class ResultView {

    public static void printPurchaseCount(Lottos lottos) {
        String format = String.format(BUY_LOTTO.message(), lottos.count());
        System.out.println(format);
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            List<LottoNumber> lottoNumbers = lotto.getLotto();
            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }

    public static void printWinningStatistic(WinningStatistic statistic) {
        System.out.println();
        System.out.println(WINNER_STATISTICS.message());
        System.out.println(LINE.message());

        Arrays.stream(Rank.values())
                .filter(Rank::win)
                .forEach(rank ->
                    printWinningStatistic(rank, statistic)
                );
    }

    private static void printWinningStatistic(Rank rank, WinningStatistic statistic) {
        MatchResultParameters matchResultParameters = new MatchResultParameters(rank, statistic);
        if (rank.isSecondPrize()) {
            System.out.println(WINNER_MATCH_BONUS_RESULT.of(matchResultParameters));
            return;
        }
        System.out.println(WINNER_MATCH_RESULT.of(matchResultParameters));
    }

    public static void printRateOfReturn(WinningStatistic statistic, Money purchaseAmount) {
        double rate = statistic.calculateRateOfReturn(purchaseAmount);
        System.out.print(TOTAL_RATE_RESULT.ofRateResult(rate));
    }
}
