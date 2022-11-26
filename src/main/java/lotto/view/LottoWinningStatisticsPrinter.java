package lotto.view;

import lotto.model.lotto.enums.LottoNumberMatchCount;
import lotto.model.lotto.result.LottoResult;

import java.util.*;

public class LottoWinningStatisticsPrinter {
    private static final String MESSAGE_FOR_EACH_NUMBERS_MATCH = "%s개 일치 (%d원)- %d개";

    public static void print(Map<LottoNumberMatchCount, Integer> prizeMoney, LottoResult lottoResult) {
        final Set<LottoNumberMatchCount> keySet = prizeMoney.keySet();
        final List<LottoNumberMatchCount> numbersMatchCandidates = new ArrayList<>(keySet.size());
        numbersMatchCandidates.addAll(keySet);
        numbersMatchCandidates.sort((a, b) -> a.value() - b.value());

        for (LottoNumberMatchCount numbersMatch : numbersMatchCandidates) {
            System.out.println(String.format(MESSAGE_FOR_EACH_NUMBERS_MATCH, numbersMatch.value(),
                    lottoResult.prizeMoneyForNumbersMatch(numbersMatch),
                    lottoResult.lottoCountForNumbersMatch(numbersMatch)));
        }
    }
}
