package lotto.view;

import lotto.domain.*;

public class ResultView {
    private static final String MESSAGE_PURCHASE_LOTTO_QUANTITY = "%d개를 구매했습니다.\n";
    private static final String MESSAGE_WIN_REPORT = "\n당첨 통계\n---------";
    private static final String MESSAGE_MATCHED_COUNT = "%d개 일치";
    private static final String MESSAGE_MATCHED_BONUS_NUBMER = ", 보너스 볼 일치";
    private static final String MESSAGE_MATCHED_RANK_COUNT = "(%d원)- %d개\n";
    private static final String MESSAGE_TOTAL_PROFIT_RATE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";

    public static void printInputErrorMessage(IllegalArgumentException e) {
        System.out.println(e);
    }

    public static void printPurchaseTicketQuantity(int ticketQuantity) {
        System.out.printf(MESSAGE_PURCHASE_LOTTO_QUANTITY, ticketQuantity);
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets().forEach(lottoTicket -> System.out.println(lottoTicket.toString()));
    }

    public static void printWinningReport(WinningResult winningResult, Money purchaseMoney) {
        System.out.println(MESSAGE_WIN_REPORT);
        printWinningRanks(winningResult);
        System.out.printf(MESSAGE_TOTAL_PROFIT_RATE, winningResult.profitRate(purchaseMoney), winningResult.profitResultDescription(purchaseMoney));
    }

    private static void printWinningRanks(WinningResult winningResult) {
        for (LottoRank rank : LottoRank.winningRanks()) {
            System.out.printf(MESSAGE_MATCHED_COUNT, rank.getMatchCount());
            printMatchedBonusNumber(rank);
            System.out.printf(MESSAGE_MATCHED_RANK_COUNT, rank.getPrizeMoney(), winningResult.countRank(rank));
        }
    }

    private static void printMatchedBonusNumber(LottoRank rank) {
        if (rank == LottoRank.SECOND) {
            System.out.print(MESSAGE_MATCHED_BONUS_NUBMER);
        }
    }
}
