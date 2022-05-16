package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.Match;
import lotto.domain.MatchPrizes;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.dto.LottoResult;
import lotto.dto.LottoWin;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        Map<Match, Integer> matchPrizes = new HashMap<>();
        matchPrizes.put(new Match(3), 5000);
        matchPrizes.put(new Match(4), 50000);
        matchPrizes.put(new Match(5), 1500000);
        matchPrizes.put(new Match(6), 2000000000);

        LottoVendingMachine machine = new LottoVendingMachine();

        LottoTicket lottoTicket = machine.sellTicket(money());
        ResultView.printTicket(lottoTicket);

        LottoResult result = machine.check(
                lottoTicket,
                new LottoWin(winningNumbers(), new MatchPrizes(matchPrizes)));
        ResultView.printStats(result);
    }

    private static Money money() {
        Money money = takeMoney();
        while (money == null) {
            money = takeMoney();
        }
        return money;
    }

    private static Money takeMoney() {
        try {
            return new Money(InputView.readMoney());
        } catch (IllegalArgumentException e) {
            ResultView.printExceptionMessage(e.getMessage());
            return null;
        }
    }

    private static WinningNumbers winningNumbers() {
        WinningNumbers winningNumbers = getWinningNumbers();
        while (winningNumbers == null) {
            winningNumbers = getWinningNumbers();
        }

        return winningNumbers;
    }

    private static WinningNumbers getWinningNumbers() {
        try {
            return new WinningNumbers(InputView.readWinningNumbers());
        } catch (IllegalArgumentException e) {
            ResultView.printExceptionMessage(e.getMessage());
            return null;
        }
    }
}
