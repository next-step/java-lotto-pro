package lotto.view;

import java.util.Collection;
import java.util.StringJoiner;

import lotto.model.Lotto;
import lotto.model.LottoCount;
import lotto.model.MatchResult;

public class OutputView {
    private OutputView() {
    }

    public static void printLottoPurchase(Collection<Lotto> lottos, LottoCount lottoCount) {
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        stringJoiner.add(lottoCount.computeNumberOfLottoStatement());
        for (Lotto lotto : lottos) {
            stringJoiner.add(lotto.toString());
        }
        System.out.println(stringJoiner);
        System.out.println();
    }

    public static void printLottoResult(MatchResult matchResult) {
        System.out.println();
        System.out.println(matchResult.toResultString());
    }
}
