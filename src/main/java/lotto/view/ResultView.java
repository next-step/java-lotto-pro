package lotto.view;

import lotto.domain.Lotties;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.WinningStatus;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final List<Rank> WINNING_LIST = Arrays.asList(Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);

    public static void printPurchaseLotties(Lotties myLotties) {
        System.out.printf("%d개를 구매했습니다.%n", myLotties.count());
        myLotties.printLotties();
        System.out.println();
    }

    public static void printWinningStatus(WinningStatus winningStatus) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        WINNING_LIST.forEach(rank -> System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getMoney() + "원)-" + winningStatus.numberOfWinning(rank) + "개"));

    }

    public static void printLottoYield(Money purchaseAmount, WinningStatus winningStatus) {
        Money winningReward = winningStatus.getWinningReward();
        System.out.println("총 수익률은 " + (winningReward.calculateLottoYield(purchaseAmount)) + "입니다.");
    }
}
