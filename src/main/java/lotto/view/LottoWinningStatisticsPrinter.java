package lotto.view;

import lotto.model.lotto.result.LottoResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoWinningStatisticsPrinter {
    private static final String MESSAGE_FOR_EACH_NUMBERS_MATCH = "%s개 일치 (%d원)- %d개";

    public static void print(Map<Integer, Integer> prizeMoney, LottoResult lottoResult) {
        final Set<Integer> keySet = prizeMoney.keySet();
        final List<Integer> numbersMatchCandidates = new ArrayList<>(keySet.size());
        numbersMatchCandidates.addAll(keySet);

        for (int numbersMatch : numbersMatchCandidates) {
            System.out.println(String.format(MESSAGE_FOR_EACH_NUMBERS_MATCH, numbersMatch,
                    lottoResult.prizeMoneyForNumbersMatch(numbersMatch),
                    lottoResult.lottoCountForNumbersMatch(numbersMatch)));
        }
    }
}
