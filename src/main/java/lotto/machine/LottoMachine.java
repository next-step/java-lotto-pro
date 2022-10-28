package lotto.machine;

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
        String money = InputView.inputText();

        LottoTickets buyLottoTickets = buyLotto(Integer.parseInt(money));

        OutputView.printInputWinnerNumbers();
        String winnerNumbers = InputView.inputText();

        OutputView.printInputBonusNumber();
        String bonusNumber = InputView.inputText();
         WinnerLottoTicket winnerLottoTicket = new WinnerLottoTicket(
                new LottoTicket(winnerNumbers),
                Integer.parseInt(bonusNumber));

        Result result = buyLottoTickets.match(winnerLottoTicket);
        result.setMoney(Integer.parseInt(money));

        OutputView.printResult(result);

    }

    public static LottoTickets buyLotto(int money) {
        return new LottoTickets(getQuantity(money));
    }

    public static int getQuantity(int money) {
        if(money < LOTTO_AMOUNT){
            throw new IllegalArgumentException(MessageConstant.ERROR_VALID_MORE_MONEY);
        }
        return money / LOTTO_AMOUNT;
    }

}
