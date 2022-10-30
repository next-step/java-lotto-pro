package step3.view;

import step3.model.lotto.Ticket;
import step3.model.lotto.Tickets;
import step3.model.machine.Result;

public class OutputView {
    public static void printTicketCount(int count) {
        System.out.println(count+"개를 구매했습니다.");
    }


    public static void printStatisticResult(double statisticResult) {
        System.out.println(String.format("총 수익률은 %.2f입니다.",statisticResult));
    }

    public static void printResult(String result, String count) {
        System.out.println(result+count);
    }

    public static void printTicket(Ticket ticket) {
        System.out.println(ticket.toString());
    }

    public static void printMoneyInput(String moneyInput) {
        System.out.println(moneyInput);
    }
}
