package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.dto.LottoResult;
import lotto.dto.LottoWin;
import lotto.view.InputView;
import lotto.view.ResultView;

public class GameManager {
    
    public void run() {
        LottoVendingMachine machine = new LottoVendingMachine(new LottoNumbersGeneratorKr());

        LottoTicket lottoTicket = machine.sellTicket(money());
        ResultView.printTicket(lottoTicket);

        LottoResult result = machine.check(
                lottoTicket,
                new LottoWin(winningNumbers()));
        ResultView.printStats(result);
    }

    private Money money() {
        Money money = takeMoney();
        while (money == null) {
            money = takeMoney();
        }
        return money;
    }

    private Money takeMoney() {
        try {
            return new Money(InputView.readMoney(), LottoTicket.PRICE);
        } catch (IllegalArgumentException e) {
            ResultView.printExceptionMessage(e.getMessage());
            return null;
        }
    }

    private WinningNumbers winningNumbers() {
        WinningNumbers winningNumbers = getWinningNumbers();
        while (winningNumbers == null) {
            winningNumbers = getWinningNumbers();
        }

        return winningNumbers;
    }

    private WinningNumbers getWinningNumbers() {
        try {
            return new WinningNumbers(InputView.readWinningNumbers());
        } catch (IllegalArgumentException e) {
            ResultView.printExceptionMessage(e.getMessage());
            return null;
        }
    }
}
