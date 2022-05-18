package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningInfo;

import java.util.Map;

public class ResultView {

    public static void printLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.allGames()) {
            System.out.println(lotto.printText());
        }
    }

    public static void printWinningResult(Map<Integer, Integer> winningResults) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        winningResults.forEach((k, v) -> {
            System.out.printf("%d개 일치 (%d)- %d개%n", k, WinningInfo.valueOfSameCount(k).winningMoney(), v);
        });
    }

    public static void printRateOfReturn(String rate) {
        System.out.printf("총 수익률은 %s입니다.", rate);
    }
}
