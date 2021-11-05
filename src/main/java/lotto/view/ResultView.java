package lotto.view;

import lotto.model.LottoPapers;
import lotto.model.LottoResult;

public class ResultView {

    private ResultView() {

    }
    public static void printBuyCountOutput(long buyCount) {
        System.out.printf("%d %s%n", buyCount, GameMessage.BUY_COUNT_OUTPUT);
    }

    public static void printLottoPapers(LottoPapers lottoPapers) {
        lottoPapers.getLottoPapers().forEach( lottoPaper -> System.out.println(lottoPaper.getLottoNumber()) );
    }

    public static void printWinningStatistics(LottoResult lottoResult) {
        System.out.println(lottoResult.getLottoResult());
    }
}
