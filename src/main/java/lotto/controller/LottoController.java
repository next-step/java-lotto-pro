package lotto.controller;

import lotto.domain.lotto.LottoTickets;
import lotto.domain.statistics.WinningResult;
import lotto.service.LottoService;
import lotto.util.StringUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final LottoService service = new LottoService();

    public void run() {
        int money = StringUtil.parseIntFrom(InputView.getPurchaseMoney());
        int purchaseAmount = service.getTicketAmount(money);
        OutputView.printTicketAmount(purchaseAmount);

        LottoTickets lottoTickets = service.issueTickets(purchaseAmount);
        OutputView.printLottoTickets(lottoTickets);

        List<Integer> numbers = StringUtil.splitParseInt(InputView.getWinningNumber());
        WinningResult winningResult = service.getWinningResult(numbers, lottoTickets);
        OutputView.printWinningResult(winningResult);

        float profitRate = service.profitRate(winningResult, purchaseAmount);
        OutputView.printProfitRate(profitRate);
    }
}
