package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String BOUGHT = "개를 구매했습니다.";
    private static final String YIELD_MESSAGE = "총 수익률은 %s입니다.";
    private static final String STATS = "%d개 일치 (%d원)- %d개\n";
    private static final String LINE_BREAK = "\n";

    public static void printBought(int count) {
        System.out.println(count + BOUGHT);
    }

    public static void printYield(String yield) {
        System.out.printf(YIELD_MESSAGE, yield);
    }

    public static void printReport(Map<Rank, Integer> matchResult) {
        StringBuilder sb = new StringBuilder("");
        matchResult.forEach((rank, count) -> {
            sb.append(String.format(STATS, rank.getCountOfMatch(), rank.getWinningMoney(), count));
        });
        System.out.print(sb.toString());
    }

    public static void printLottoList(Lottos lottos) {
        List<Lotto> lottoGroup = lottos.getLottoGroup();
        StringBuilder sb = new StringBuilder("");
        for (Lotto lotto : lottoGroup) {
            sb.append(lotto.toString()+LINE_BREAK);
        }
        System.out.print(sb.toString());
    }
}
