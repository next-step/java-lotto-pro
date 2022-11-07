package lotto.ui;


import lotto.domain.*;

import java.util.Map;

public class ConsoleResultView implements ResultView {
    private static final String MESSAGE_FOR_PRINT_LOTTO_TICKETS = "수동으로 %d장, 자동으로 %d개를 구매했습니다.%n";
    private static final String MESSAGE_FOR_PRINT_TOTAL_YIELD = "총 수익률은 %.2f입니다.";


    @Override
    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.lottos()) {
            System.out.println(lotto);
        }
    }

    @Override
    public void printAllLottoTicketCount(int manualLottoTicketCount, int autoLottoTicketCount) {
        System.out.printf(MESSAGE_FOR_PRINT_LOTTO_TICKETS, manualLottoTicketCount, autoLottoTicketCount);
    }

    @Override
    public void printWinningResult(WinningLotto winningLotto, Lottos lottos) {
        WinningResult result = lottos.match(winningLotto);
        printRanks(result.reportRanks());
        printYield(result.reportYield());
    }

    private void printRanks(Map<WinningLottoRank, Integer> ranks) {
        StringBuffer sb = new StringBuffer();
        sb.append("당첨 통계\n");
        sb.append("---------\n");
        WinningLottoRank[] rankValues = WinningLottoRank.values();
        for (int i = rankValues.length - 2; i >= 0; i--) {
            printRank(ranks, sb, rankValues[i]);
        }
        System.out.println(sb);
    }

    private static void printRank(Map<WinningLottoRank, Integer> ranks, StringBuffer sb, WinningLottoRank rank) {
        sb.append(rank.getMatchCount());
        sb.append("개 일치");
        if (rank == WinningLottoRank.SECOND) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (");
        sb.append(rank.getReward());
        sb.append("원)");

        sb.append("- ");
        sb.append(ranks.get(rank));
        sb.append("개\n");
    }

    private void printYield(double yield) {
        System.out.printf(MESSAGE_FOR_PRINT_TOTAL_YIELD, yield);
    }
}
