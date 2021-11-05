package lotto.view;

import java.util.List;

import lotto.domain.LottoTicket;

public class OutputView {
    private OutputView() {
    }

    public static void printLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }
    }
}
