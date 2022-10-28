package lotto.ticket;

import java.util.ArrayList;
import java.util.List;
import lotto.machine.Result;
import lotto.money.Money;
import lotto.system.OutputView;

public class LottoTickets {
    List<LottoTicket> lottoTickets = new ArrayList<>();

    public LottoTickets(int quantity) {
        OutputView.printReceipt(quantity);
        for (int i = 0; i < quantity; i++) {
            lottoTickets.add(new LottoTicket());
            lottoTickets.get(i).printLotto();
        }
    }

    public int getQuantity() {
        return lottoTickets.size();
    }

    public Result match(WinnerLottoTicket winnerLottoTicket, Money money) {
        Result result = new Result();
        for (LottoTicket ticket : lottoTickets){
            result.addCount(
                    ticket.match(winnerLottoTicket.getLotto()),
                    winnerLottoTicket.matchBonus(ticket));
        }
        result.setMoney(money.amount());
        return result;
    }

}
