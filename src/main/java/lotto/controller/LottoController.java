package lotto.controller;

import lotto.domain.lotto.LottoTickets;
import lotto.domain.purchase.PurchaseAmount;
import lotto.domain.purchase.PurchaseMoney;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final LottoService service = new LottoService();

    public void run() {
        try {
            PurchaseMoney purchaseMoney = service.getPurchaseMoney(InputView.getPurchaseMoney());
            PurchaseAmount purchaseAmount = service.getPurchaseAmount(purchaseMoney, InputView.getManualLottoCount());
            OutputView.printTicketAmount(purchaseAmount.getManualTicketAmount(), purchaseAmount.getAutoTicketAmount());

            List<String> manualLottoNumbers = InputView.getManualLottoNumbers(purchaseAmount.getManualTicketAmount());
            LottoTickets lottoTickets = service.issueTickets(purchaseAmount, manualLottoNumbers);
            OutputView.printLottoTickets(lottoTickets);

            WinningNumbers winningNumbers = service.getWinningNumbers(InputView.getWinningNumber(), InputView.getBonusNumber());
            WinningResult winningResult = service.getWinningResult(winningNumbers, lottoTickets);
            OutputView.printWinningResult(winningResult);

            float profitRate = service.profitRate(winningResult, purchaseMoney);
            OutputView.printProfitRate(profitRate);

        } catch (RuntimeException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }
}
