package lotto.machine;

import lotto.money.Money;
import lotto.system.InputView;
import lotto.system.MessageConstant;
import lotto.system.OutputView;
import lotto.ticket.LottoTicket;
import lotto.ticket.LottoTickets;
import lotto.ticket.WinnerLottoTicket;

public class LottoMachine {
    private static int LOTTO_AMOUNT = 1_000;

    public static void gameStart(){
        OutputView.printInputMoney();
        Money money = new Money(InputView.inputText());
        LottoTickets buyLottoTickets = buyLotto(money);

        OutputView.printInputWinnerNumbers();
        String winnerNumbers = InputView.inputText();

        OutputView.printInputBonusNumber();
        String bonusNumber = InputView.inputText();
        WinnerLottoTicket winnerLottoTicket2 = new WinnerLottoTicket(
                new LottoTicket(winnerNumbers),
                Integer.parseInt(bonusNumber));

        OutputView.printResult(buyLottoTickets.match(winnerLottoTicket2, money));
    }

    public static LottoTickets buyLotto(Money money) {
        int amount = getQuantity(money.amount());
        OutputView.printReceipt(amount);
        return new LottoTickets(amount);
    }

    public static int getQuantity(int money) {
        if(money < LOTTO_AMOUNT){
            throw new IllegalArgumentException(MessageConstant.ERROR_VALID_MORE_MONEY);
        }
        return money / LOTTO_AMOUNT;
    }

}