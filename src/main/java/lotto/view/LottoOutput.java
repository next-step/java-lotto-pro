package lotto.view;

import lotto.domain.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoOutput {

    private LottoOutput() {
    }

    public static void printLottoCount(int manuallyLottoCount, int autoLottoCount) {
        OutputConsole.purchaseResult(manuallyLottoCount, autoLottoCount);
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

    public static void printLottos(Lottos lottos) {
        lottos.getLottos()
                .stream()
                .forEach(LottoOutput::printLotto);
        System.out.println();
    }

    private static void printLotto(Lotto lotto) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            stringBuilder.append(lottoNumber.toInt());
            stringBuilder.append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

}

