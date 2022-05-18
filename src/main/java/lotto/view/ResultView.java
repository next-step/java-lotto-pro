package lotto.view;

import lotto.domain.*;

public class ResultView {
    private static final String MESSAGE_PURCHASE_LOTTO_QUANTITY = "%d개를 구매했습니다.\n";
    private static final String MESSAGE_WIN_REPORT = "\n당첨 통계\n---------";
    private static final String MESSAGE_TOTAL_PROFIT_RATE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";

    public static void printInputErrorMessage(IllegalArgumentException e) {
        System.out.println(e);
    }

    public static void printPurchaseTicketQuantity(int ticketQuantity) {
        System.out.printf(MESSAGE_PURCHASE_LOTTO_QUANTITY, ticketQuantity);
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.print(lottoTickets);
    }

    public static void printWinningReport(WinningResult winningResult, Money purchaseMoney) {
        System.out.println(MESSAGE_WIN_REPORT);
        System.out.print(winningResult);
        System.out.printf(MESSAGE_TOTAL_PROFIT_RATE, winningResult.profitRate(purchaseMoney), winningResult.profitResultDescription(purchaseMoney));
    }
}
