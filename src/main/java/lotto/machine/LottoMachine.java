package lotto.machine;

import lotto.system.InputView;
import lotto.system.OutputView;
import lotto.ticket.LottoTicket;
import lotto.ticket.LottoTickets;

public class LottoMachine {
    private static int LOTTO_AMOUNT = 1000;

    public static void gameStart(){

        OutputView.printInputMoney();
        String money = InputView.inputMoney();

        LottoTickets buyLottoTickets = buyLotto(Integer.parseInt(money));

        OutputView.printInputWinningNumbers();
        String winningNumbers = InputView.inputWinningNumbers();
        LottoTicket winningLottoTicket  = new LottoTicket(winningNumbers);

        Result result = buyLottoTickets.match(winningLottoTicket);
        result.setMoney(Integer.parseInt(money));
        printResult(result);
        int v = (int) (Integer.parseInt(money) / result.yieldRate());

    }

    public static LottoTickets buyLotto(int money) {
        return new LottoTickets(getQuantity(money));
    }

    public static int getQuantity(int money) {
        if(money < LOTTO_AMOUNT){
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
        return money / LOTTO_AMOUNT;
    }

    public static void printResult(Result result) {
        OutputView.printResult(result);
    }

}
