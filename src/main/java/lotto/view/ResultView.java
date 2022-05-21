package lotto.view;

import lotto.domain.Lotties;
import lotto.domain.LottoCount;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.WinningStatus;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final List<Rank> WINNING_LIST = Arrays.asList(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);

    public static void printPurchaseLotties(Lotties myLotties, LottoCount lottoCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", lottoCount.getManual(), lottoCount.getAuto());
        myLotties.getLotties().forEach(System.out::println);
        System.out.println();
    }

    public static void printWinningStatus(WinningStatus winningStatus) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        WINNING_LIST.forEach(rank -> System.out.printf(rank.getMessage() + "- %d개%n", winningStatus.numberOfWinning(rank)));

    }

    public static void printLottoYield(Money purchaseAmount, WinningStatus winningStatus) {
        System.out.printf("총 수익률은 %.02f입니다.%n", winningStatus.getWinningYield(purchaseAmount));

    }
}
