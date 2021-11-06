package lotto.view;

import lotto.model.LottoPapers;
import lotto.model.LottoResult;
import lotto.model.LottoWinningPrice;

import java.util.Arrays;

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
        StringBuilder resultMsg = new StringBuilder();
        resultMsg.append("당첨 통계\n");
        resultMsg.append("---------\n");

        Arrays.stream(LottoWinningPrice.values())
                .filter(LottoWinningPrice::isView)
                .forEach(
                lottoWinningPrice
                        -> resultMsg.append(String.format("%d개 일치 (%d원) - %d개\n",
                        lottoWinningPrice.getWinningCount(),
                        lottoWinningPrice.getReward(),
                        lottoResult.getMatchCounts().get(lottoWinningPrice) )) );

        resultMsg.append(String.format("총 수익률은 %.2f 입니다.", lottoResult.getYield()));
        System.out.println(resultMsg.toString());
    }
}
