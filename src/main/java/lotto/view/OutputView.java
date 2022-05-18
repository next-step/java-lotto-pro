package lotto.view;

import lotto.domain.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static lotto.domain.LottoConstant.LOTTO_MINIMUM_MATCHING_COUNT;

public class OutputView {
    public static void printMyLotto(PurchasedLotto lottos) {
        List<Lotto> lottoList = lottos.getLottoList();
        for (Lotto lotto : lottoList) {
            OutputView.printMessage(lotto.toString());
        }
        OutputView.printLine();
    }

    public static void showLottoResult(LottoResult result, Money money) {
        showLottoStatistics(result);
        showLottoProfit(result, money);
    }

    public static void showLottoStatistics(LottoResult result) {
        OutputView.printMessage("당첨 통계");
        OutputView.printMessage("---------");
        List<Ranking> rankings = Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.getMatchingCount() >= LOTTO_MINIMUM_MATCHING_COUNT)
                .collect(toList());

        for (Ranking item : rankings) {
            printMatchingMessage(result, item.getMatchingCount(), item.isMatchBonus(), item);
        }
    }

    private static void printMatchingMessage(LottoResult result, int matchCount, boolean matchBonus, Ranking rank) {
        OutputView.printMessage("%d개 일치", matchCount, rank.getReward());
        if (matchBonus) {
            OutputView.printMessageWithoutNewLine(", 보너스 볼 일치");
        }
        OutputView.printMessage("(%d원)- %d개\r\n", rank.getReward(), result.findRankings(matchCount, matchBonus).size());
    }

    public static void showLottoProfit(LottoResult result, Money money) {
        BigDecimal profit = money.calculateWinningProfit(result);
        OutputView.printMessage("총 수익률은 " + profit + "입니다.");
    }

    public static void printMessageWithoutNewLine(String message) {
        System.out.print(message);
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
