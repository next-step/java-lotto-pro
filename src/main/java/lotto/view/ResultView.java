package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;

import java.util.Map;

public class ResultView {

    public static void printLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.allGames()) {
            System.out.println(lotto.printText());
        }
    }

    public static void printWinningResult(Map<Rank, Integer> winningResults) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        winningResults.forEach((k, v) -> {
            if (k.equals(Rank.MISS)) {
                return;
            }
            String secondText = "";
            if (k.equals(Rank.SECOND)) {
                secondText = ", 보너스 볼 일치";
            }
            System.out.printf("%d개 일치%s (%d)- %d개%n", k.sameCount(), secondText, k.winningMoney(), v);
        });
    }

    public static void printRateOfReturn(String rate) {
        System.out.printf("총 수익률은 %s입니다.", rate);
    }
}
