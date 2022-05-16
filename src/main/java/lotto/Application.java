package lotto;

import lotto.domain.LottoTicket;
import lotto.dto.LottoResult;
import lotto.dto.LottoWin;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        Map<Match, Integer> matchingPrize = new HashMap<>();
        matchingPrize.put(new Match(3), 5000);
        matchingPrize.put(new Match(4), 50000);
        matchingPrize.put(new Match(5), 1500000);
        matchingPrize.put(new Match(6), 2000000000);

        LottoVendingMachine machine = new LottoVendingMachine();

        LottoTicket lottoTicket = machine.sellTicket(InputView.takeMoney());
        ResultView.printTicket(lottoTicket);

        LottoResult result = machine.check(
                lottoTicket,
                new LottoWin(InputView.readWinningNumbers(), matchingPrize));
        ResultView.printStats(result);
    }
}
