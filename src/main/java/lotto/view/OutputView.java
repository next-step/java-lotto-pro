package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoStore.LOTTO_PRICE;

public class OutputView {
    public static void printLottoResult(LottoResult lottoResult) {
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.values());
        Collections.reverse(lottoRanks);

        printLottoRank(lottoRanks, lottoResult);
    }

    private static void printLottoRank(List<LottoRank> lottoRanks, LottoResult lottoResult) {
        System.out.println("\n당첨 통계\n---------");

        for (LottoRank lottoRank : lottoRanks) {
            int matchRank = lottoRank.matchRank(lottoResult);
            printMatch(lottoRank, matchRank);
        }
    }

    private static void printMatch(LottoRank lottoRank, int count) {
        System.out.print(String.format("%d개 일치", lottoRank.getMatch()));

        if (lottoRank.hasBonus()) {
            System.out.print(", 보너스 볼 일치");
        }
        System.out.println(String.format(" (%d원)- %d개", lottoRank.getPrize(), count));
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
