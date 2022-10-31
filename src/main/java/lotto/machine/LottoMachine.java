package lotto.machine;

import lotto.money.Money;
import lotto.quantity.LottoQuantity;
import lotto.system.InputView;
import lotto.system.MessageConstant;
import lotto.system.OutputView;
import lotto.ticket.LottoTicket;
import lotto.ticket.LottoTickets;
import lotto.ticket.WinnerLottoTicket;

public class LottoMachine {
    private static int LOTTO_AMOUNT = 1_000;

    public static void gameStart(){
        Money money = getMoney();
        LottoQuantity manualLottoQuantity = getLottoQuantity(money);
        LottoTickets buyLottoTickets = getBuyLottoTickets(money, manualLottoQuantity);
        String winnerNumbers = getWinnerNumbers();
        WinnerLottoTicket winnerLottoTicket = getWinnerLottoTicket(winnerNumbers);
        OutputView.printResult(buyLottoTickets.match(winnerLottoTicket, money));
    }

    private static String getWinnerNumbers() {
        OutputView.printInputWinnerNumbers();
        String winnerNumbers = InputView.inputText();
        return winnerNumbers;
    }

    private static Money getMoney() {
        OutputView.printInputMoney();
        return new Money(InputView.inputText());
    }

    public static LottoQuantity getLottoQuantity(Money money) {
        OutputView.printInputManualLottoQuantity();
        int totalQuantity = getQuantity(money.amount());
        String manualQuantity = InputView.inputText();
        return new LottoQuantity(totalQuantity, manualQuantity);
    }

    private static LottoTickets getBuyLottoTickets(Money money, LottoQuantity manualLottoQuantity) {
        if(manualLottoQuantity.quantity() > 0){
            OutputView.printInputManualLottoNumbers();
        }
        LottoTickets buyLottoTickets = buyLotto(money, manualLottoQuantity);
        return buyLottoTickets;
    }

    private static WinnerLottoTicket getWinnerLottoTicket(String winnerNumbers) {
        OutputView.printInputBonusNumber();
        String bonusNumber = InputView.inputText();
        WinnerLottoTicket winnerLottoTicket = new WinnerLottoTicket(
                new LottoTicket(winnerNumbers),
                Integer.parseInt(bonusNumber));
        return winnerLottoTicket;
    }

    public static LottoTickets buyLotto(Money money) {
        int amount = getQuantity(money.amount());
        return new LottoTickets(amount);
    }

    public static LottoTickets buyLotto(Money money, LottoQuantity manualLottoQuantity) {
        int autoQuantity = getQuantity(money.amount());
        return new LottoTickets(autoQuantity, manualLottoQuantity);
    }

    public static int getQuantity(int money) {
        if(money < LOTTO_AMOUNT){
            throw new IllegalArgumentException(MessageConstant.ERROR_VALID_MORE_MONEY);
        }
        return money / LOTTO_AMOUNT;
    }

}
