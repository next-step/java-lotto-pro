package lotto.view;

import lotto.model.LottoPapers;
import lotto.model.LottoResult;
import lotto.model.LottoWinningPrice;

import java.util.Arrays;

public class ResultView {

    private ResultView() {

    }
    public static void printBuyCountOutput(int manualBuyCount, int buyCount) {
        System.out.printf(GameMessage.FORMAT_BUY_COUNT_OUTPUT, manualBuyCount, buyCount);
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
                        -> resultMsg.append(String.format(printWinningMessage(lottoWinningPrice),
                        lottoWinningPrice.getWinningCount(),
                        lottoWinningPrice.getReward(),
                        lottoResult.getMatchCounts().get(lottoWinningPrice) )) );

        resultMsg.append(String.format("총 수익률은 %.2f 입니다.", lottoResult.getYield()));
        System.out.println(resultMsg.toString());
    }

    private static String printWinningMessage(LottoWinningPrice lottoWinningPrice) {

        if (lottoWinningPrice == LottoWinningPrice.BONUS) {
            return "%d개 일치, 보너스 볼 일치 (%d원) - %d개\n";
        }
        return "%d개 일치 (%d원) - %d개\n";
    }
}
