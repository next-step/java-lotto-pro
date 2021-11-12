package lotto.view;

import java.util.StringJoiner;

import lotto.model.LottoCount;
import lotto.model.Lottos;
import lotto.model.MatchResult;

public class OutputView {
    private OutputView() {
    }

    public static void printLottoPurchase(Lottos lottos, LottoCount lottoCount) {
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        stringJoiner.add(lottoCount.computeNumberOfLottoStatement());
        stringJoiner.add(lottos.toString());
        System.out.println(stringJoiner);
        System.out.println();
    }

    public static void printLottoResult(MatchResult matchResult) {
        System.out.println();
        System.out.println(matchResult.toResultString());
    }
}
