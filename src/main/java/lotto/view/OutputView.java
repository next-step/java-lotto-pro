package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoStore.LOTTO_PRICE;

public class OutputView {
    public static void printLottoResult(LottoTicket winningTicket, List<LottoTicket> autoTickets) {
        List<Integer> matchList = winningTicket.matchList(autoTickets);
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.values());
        Collections.reverse(lottoRanks);

        printLottoRank(matchList, lottoRanks);
        printRateOfReturn(matchList, lottoRanks);
    }

    private static void printLottoRank(List<Integer> matchList, List<LottoRank> lottoRanks) {
        System.out.println("\n당첨 통계\n---------");
        for (LottoRank lottoRank : lottoRanks) {
            int matchCount = LottoStatistics.matchCount(matchList, lottoRank);
            printMatch(lottoRank.getMatch(), lottoRank.getPrize(), matchCount);
        }
    }

    private static void printMatch(int match, long prize, int count) {
        System.out.println(String.format("%d개 일치(%d원)- %d개",
                match,
                prize,
                count
            )
        );
    }

    private static void printRateOfReturn(List<Integer> matchList, List<LottoRank> lottoRanks) {
        int profit = LottoStatistics.lottoProfit(matchList, lottoRanks);
        float rateOfReturn = profit / (matchList.size() * LOTTO_PRICE);

        System.out.print(String.format("총 수익률은 %.2f입니다.", rateOfReturn));
        if (rateOfReturn < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    public static void printLottoAutoTickets(List<LottoTicket> tickets) {
        printLottoCount(tickets);
        printLottoNumbers(tickets);
        System.out.println();
    }

    private static void printLottoNumbers(List<LottoTicket> tickets) {
        for (LottoTicket ticket : tickets) {
            System.out.println(ticket.getLottoTicket());
        }
    }

    private static void printLottoCount(List<LottoTicket> tickets) {
        System.out.println(String.format("%d개를 구매했습니다.", tickets.size()));
    }
}
