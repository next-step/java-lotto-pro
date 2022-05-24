package lotto.ui;

import lotto.domain.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class ResultView {

    private ResultView() { }

    public static void printTicketCount(int purchasePrice) {
        System.out.printf("%d개를 구매했습니다.%n", purchasePrice);
    }

    public static void printTicket(String ticketLottoNumbers) {
        System.out.println(ticketLottoNumbers);
    }

    public static void printGameResult(Map<Rank, Integer> score, double earningRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        List<Rank> printRankList = Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.MISS)
                .sorted(Comparator.comparing(Rank::getWinningMoney))
                .collect(Collectors.toList());

        for (Rank rank : printRankList) {
            printGameResultByRank(score, rank);
        }

        printEarningRate(earningRate);
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    private static void printEarningRate(double earningRate) {
        StringBuilder earningRateMessage = new StringBuilder(String.format("총 수익률은 %.2f입니다.", earningRate));
        if (earningRate < 1) {
            earningRateMessage.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        System.out.println(earningRateMessage);
    }

    private static void printGameResultByRank(Map<Rank, Integer> score, Rank rank) {
        if (rank == Rank.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%d원)- %d개%n"
                    , rank.getCountOfMatch(), rank.getWinningMoney(), score.getOrDefault(rank, 0));
            return;
        }

        System.out.printf("%d개 일치 (%d원)- %d개%n"
                , rank.getCountOfMatch(), rank.getWinningMoney(), score.getOrDefault(rank, 0));
    }
}
