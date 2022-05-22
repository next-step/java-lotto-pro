package lotto.ui;

import lotto.domain.Rank;

import java.util.Map;

public class ResultView {
    public static void printTicketCount(int purchasePrice) {
        System.out.println(String.format("%d개를 구매했습니다.", purchasePrice));
    }

    public static void printTicket(String ticketLottoNumbers) {
        System.out.println(ticketLottoNumbers);
    }

    public static void printGameResult(Map<Rank, Integer> score, double earningRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(String.format("3개 일치 (%d원)- %d개", Rank.FIFTH.getWinningMoney(), score.get(Rank.FIFTH) == null ? 0 : score.get(Rank.FIFTH)));
        System.out.println(String.format("4개 일치 (%d원)- %d개", Rank.FOURTH.getWinningMoney(), score.get(Rank.FOURTH) == null ? 0 : score.get(Rank.FOURTH)));
        System.out.println(String.format("5개 일치 (%d원)- %d개", Rank.THIRD.getWinningMoney(), score.get(Rank.THIRD) == null ? 0 : score.get(Rank.THIRD)));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (%d원)- %d개", Rank.SECOND.getWinningMoney(), score.get(Rank.SECOND) == null ? 0 : score.get(Rank.SECOND)));
        System.out.println(String.format("6개 일치 (%d원)- %d개", Rank.FIRST.getWinningMoney(), score.get(Rank.FIRST) == null ? 0 : score.get(Rank.FIRST)));
        StringBuffer earningRateMessage = new StringBuffer(String.format("총 수익률은 %.2f입니다.", earningRate));
        if (earningRate < 1) {
            earningRateMessage.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        System.out.println(earningRateMessage);
    }
}
