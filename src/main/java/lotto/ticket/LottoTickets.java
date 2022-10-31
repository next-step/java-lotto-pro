package lotto.ticket;

import java.util.ArrayList;
import java.util.List;
import lotto.machine.Result;
import lotto.money.Money;
import lotto.quantity.LottoQuantity;
import lotto.system.InputView;
import lotto.system.OutputView;

public class LottoTickets {
    List<LottoTicket> lottoTickets = new ArrayList<>();

    public LottoTickets(int quantity) {
        for (int i = 0; i < quantity; i++) {
            lottoTickets.add(new LottoTicket());
            lottoTickets.get(i).printLotto();
        }
    }

    public LottoTickets(int totalQuantity, LottoQuantity manualLottoQuantity) {
        int autoQuantity = totalQuantity - manualLottoQuantity.quantity();

        for (int i = 0; i < manualLottoQuantity.quantity(); i++) {
            LottoTicket lottoTicket = new LottoTicket(InputView.inputText());
            lottoTickets.add(lottoTicket);
        }

        for (int i = 0; i < autoQuantity; i++) {
            LottoTicket lottoTicket = new LottoTicket();
            lottoTickets.add(lottoTicket);
        }
        OutputView.printReceipt(manualLottoQuantity.quantity(), autoQuantity);
        printLottoTickets();
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

    public void printLottoTickets(){
        for (LottoTicket lottoTicket: lottoTickets){
            lottoTicket.printLotto();
        }
    }

}
