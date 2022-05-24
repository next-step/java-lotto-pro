package lotto.interfaces.controller;

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
        LottoRequest.PurchaseRequest purchaseRequest = inputView.inputPayAmount();

        LottoTickets lottoTickets = lottoService.purchaseLottoTicketsByAuto(purchaseRequest.getPayAmount());

        resultView.outPutPurchaseHistory(new LottoResponse.PurchasedLottoResultDto(lottoTickets));

        return lottoTickets;
    }

    private void confirmWinningLottoTicket(final LottoTickets lottoTickets) {
        LottoRequest.ResultRequest resultRequest = inputView.inputWinningNumbers();

        LottoResult lottoWinningResult = lottoService.getRankCount(resultRequest.getWinningNumbers(), resultRequest.getBonusBall(), lottoTickets);

        resultView.outPutLottoResult(
                new LottoResponse.LottoConfirmResult(lottoWinningResult.getRankCounter(), lottoWinningResult.calculateYield(lottoTickets.getLottoTicketsCount())));
    }
}
