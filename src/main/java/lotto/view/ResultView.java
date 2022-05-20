package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.Match;
import lotto.domain.Rank;
import lotto.dto.LottoResult;
import lotto.dto.LottoResultItem;

public class ResultView {

    private ResultView() {
    }

    public static void printTicket(LottoTicket lottoTicket) {
        System.out.println();
        System.out.println(lottoTicket.size() + "개를 구매했습니다.");
        System.out.println(lottoTicket);
    }

    public static void printStats(LottoResult result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (LottoResultItem item : result.getItems()) {
            printRankPrizeCount(
                    item.getRank(),
                    item.getMatch(),
                    item.getPrizeMoney(),
                    item.getCount());
        }
        System.out.println("총 수익률은 " + result.getEarningRatio() + "입니다. (>1: 수익, <1: 손실)");
    }

    private static void printRankPrizeCount(Rank rank, Match match, int winningPrize, int count) {
        if (rank == Rank.MISS) {
            return;
        }

        if (rank == Rank.SECOND) {
            System.out.println(match + "개 일치, 보너스 볼 일치 (" +
                    winningPrize + "원)- " + count + "개");
            return;
        }

        System.out.println(match + "개 일치 (" + winningPrize + "원)- " + count + "개");
    }

    public static void printExceptionMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
