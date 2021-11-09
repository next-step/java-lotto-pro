package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printLottoCount(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.", lottoCount);
        System.out.println();
    }

    public static void printLottoNumbers(List<Lotto> lottoList) {
        StringBuffer sb = new StringBuffer();
        lottoList.stream()
                .forEach(l -> {
                    sb.append("[");
                    sb.append(String.join(", ", l.getLottoNumbers()));
                    sb.append("]\n");
                });
        System.out.println(sb);
        System.out.println();
    }

    public static void printWinningStatistics(Map<LottoPrize, Integer> lottoWinningMap) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(LottoPrize.values())
                .filter(l -> !l.equals(LottoPrize.NONE))
                .forEach(l -> {
                    if (l.equals(LottoPrize.SECOND)) {
                        System.out.printf("%d개 일치, 보너스 볼 일치 (%d원)- %d개", l.getCount(), l.getMoney(), lottoWinningMap.getOrDefault(l, 0));
                        System.out.println();
                        return;
                    }
                    System.out.printf("%d개 일치 (%d원)- %d개", l.getCount(), l.getMoney(), lottoWinningMap.getOrDefault(l, 0));
                    System.out.println();
                });
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.2f입니다.", profitRate);
    }
}
