package lotto.view;

import lotto.domain.LottoCalculator;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoOutput {

    private LottoOutput() {
    }

    public static void printLottoCount(int lottoCount) {
        OutputConsole.purchaseResult(lottoCount);
    }

    public static void printStatistics(WinningLotto winningLotto, Lottos lottos) {
        OutputConsole.statistics();
        printWinnigCount(winningLotto, lottos);
        printRateOfReturn(winningLotto, lottos);
    }

    private static void printWinnigCount(WinningLotto winningLotto, Lottos lottos) {
        List<Rank> ranks = Arrays.asList(Rank.values());
        Collections.reverse(ranks);
        ranks.stream()
                .filter(rank -> rank != Rank.NO_MATCH)
                .forEach(rank -> {
                    int count = LottoCalculator.winningCount(winningLotto, lottos, rank);
                    OutputConsole.winningCount(rank, count);
                });
    }

    private static void printRateOfReturn(WinningLotto winningLotto, Lottos lottos) {
        OutputConsole.rateOfReturn(LottoCalculator.rateOfReturn(winningLotto, lottos));
    }

}

