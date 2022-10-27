package lotto.view;

import lotto.domain.LottoTicket;

import java.util.List;

public class ResultView {
    public static void printGetMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printTickets(List<LottoTicket> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");

        for (LottoTicket ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }
}
