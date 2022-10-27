package lotto.ticket;

import java.util.ArrayList;
import java.util.List;
import lotto.machine.Result;
import lotto.system.OutputView;

public class LottoTickets {
    List<LottoTicket> lottoTickets = new ArrayList<>();

    public LottoTickets(int quantity) {
        for (int i = 0; i < quantity; i++) {
            lottoTickets.add(new LottoTicket());
        }
        printReceipt();
        System.out.println(lottoTickets);
    }

    public int getQuantity() {
        return lottoTickets.size();
    }

    public Result match(WinnerLottoTicket winnerLottoTicket) {
        Result result = new Result();

        for (LottoTicket ticket : lottoTickets){
            result.addCount(
                    ticket.match(winnerLottoTicket.getLotto()),
                    winnerLottoTicket.matchBonus(ticket));
        }
        return result;
    }

    private void printReceipt() {
        OutputView.printReceipt(lottoTickets.size());
    }

    @Override
    public String toString() {
        return lottoTickets.toString();
    }

}
