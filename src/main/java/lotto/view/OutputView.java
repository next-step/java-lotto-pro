package lotto.view;

import lotto.domain.*;

import java.util.List;

import static lotto.domain.LottoConstant.LOTTO_SIZE;

public class OutputView {
    public static void printMyLotto(PurchasedLottos lottos) {
        List<Lotto> lottoList = lottos.getLottoList();
        for (Lotto lotto : lottoList) {
            OutputView.printMessage(lotto.toString());
        }
        OutputView.printLine();
    }

    public static void showLottoStatistics(LottoResult result) {
        OutputView.printMessage("당첨 통계");
        OutputView.printMessage("---------");
        for (int matching = 3; matching <= LOTTO_SIZE; matching++) {
            Ranking rank = Ranking.findRank(matching);
            OutputView.printMessage("%d개 일치 (%d원)- %d개\r\n", matching, rank.getReward(), result.findRankings(matching).size());
        }
    }

    public static void showLottoProfit(LottoResult result, Money money) {
        double profit = (double) result.calculateWinningMoney() / money.getMoney();
        OutputView.printMessage("총 수익률은 %.2f입니다.", profit);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage(String format, Object... args) {
        System.out.printf(format, args);
    }

    public static void printLine() {
        System.out.println();
    }
}
