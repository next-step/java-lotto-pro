package lotto.interfaces.controller;

import lotto.application.command.LottoCommand;
import lotto.application.service.LottoService;
import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;
import lotto.interfaces.dto.LottoRequest;
import lotto.interfaces.dto.LottoResponse;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(LottoService lottoService, InputView inputView, ResultView resultView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        LottoTickets lottoTickets = purchaseLottoTickets();

        confirmWinningLottoTicket(lottoTickets);
    }

    private LottoTickets purchaseLottoTickets() {
        LottoRequest.PurchaseRequest purchaseRequest = inputView.inputPurchaseInfo();

        LottoCommand.Purchase command = new LottoCommand.Purchase(purchaseRequest.getPayAmount(), purchaseRequest.getManualLottoCount(), purchaseRequest.getManualLottoNumbers());
        LottoTickets lottoTickets = lottoService.purchaseLottoTicketsByAuto(command);

        resultView.outPutPurchaseHistory(new LottoResponse.PurchasedLottoResultDto(lottoTickets, purchaseRequest.getManualLottoCount()));

        return lottoTickets;
    }

    private void confirmWinningLottoTicket(final LottoTickets lottoTickets) {
        LottoRequest.ResultRequest resultRequest = inputView.inputWinningNumbers();

        LottoResult lottoWinningResult = lottoService.getRankCount(resultRequest.getWinningNumbers(), resultRequest.getBonusBall(), lottoTickets);

        resultView.outPutLottoResult(
                new LottoResponse.LottoConfirmResult(lottoWinningResult.getRankCounter(), lottoWinningResult.calculateYield(lottoTickets.getLottoTicketsCount())));
    }
}
