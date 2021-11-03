package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoPrize;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printLottoCount(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.", lottoCount);
        System.out.println();
    }

    public static void printLottoNumbers(List<LottoNumbers> lottoNumbersList) {
        lottoNumbersList.stream()
                .forEach(l -> {
                    StringBuffer sb = new StringBuffer();
                    sb.append("[");
                    sb.append(String.join(", ", l.getLottoNumbers()));
                    sb.append("]");
                    System.out.println(sb);
                });
        System.out.println();
    }

    public static void printWinningStatistics(Map<LottoPrize, Integer> lottoWinningMap) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (LottoPrize lottoPrize : lottoWinningMap.keySet()) {
            System.out.printf("%d개 일치 (%d원)- %d개", lottoPrize.getCount(), lottoPrize.getMoney(), lottoWinningMap.get(lottoPrize));
            System.out.println();
        }
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", profitRate);
    }
}
