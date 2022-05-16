package lotto.controller;

import static lotto.domain.Money.LOTTO_TICKET_PRICE;

import lotto.controller.converter.LottoResultDTOConverter;
import lotto.controller.converter.MoneyConverter;
import lotto.controller.converter.WinningLottoConverter;
import lotto.controller.dto.LottoResultDTO;
import lotto.controller.dto.MoneyDTO;
import lotto.controller.dto.WinningLottoDTO;
import lotto.domain.PurchasedLottoTickets;
import lotto.domain.LottoVendingMachine;
import lotto.domain.LottoWinningResults;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoVendingMachine vendingMachine;

    public LottoController() {
        this.vendingMachine = new LottoVendingMachine();
    }

    public void run() {
        PurchasedLottoTickets lottoTickets = buyLottoTickets();

        int purchasedTicketsCount = lottoTickets.purchasedTicketsCount();

        reportingLottoTicketsInformation(lottoTickets, purchasedTicketsCount);

        LottoWinningResults winningResults = getResultWithWinningLotto(lottoTickets);

        reportingLottoResult(purchasedTicketsCount, winningResults);

    }

    private void reportingLottoTicketsInformation(PurchasedLottoTickets lottoTickets, int purchasedTicketsCount) {
        OutputView.printPurchasedTicketsCount(purchasedTicketsCount);
        OutputView.printTicketsNumbers(lottoTickets.toString());
    }

    private void reportingLottoResult(int purchasedTicketsCount, LottoWinningResults winningResults) {
        int usedMoney = purchasedTicketsCount * LOTTO_TICKET_PRICE;
        LottoResultDTO resultDTO = LottoResultDTOConverter.convert(winningResults);
        resultDTO.setProfitRate(winningResults.profitRate(Money.from(usedMoney)));
        OutputView.printResultReporting(resultDTO);
    }

    private LottoWinningResults getResultWithWinningLotto(PurchasedLottoTickets lottoTickets) {
        WinningLottoDTO winningLottoDTO = InputView.inputLottoInformation();
        WinningLotto winningLotto = WinningLottoConverter.convert(winningLottoDTO);
        return lottoTickets.checkWinningLotto(winningLotto);
    }

    private PurchasedLottoTickets buyLottoTickets() {
        MoneyDTO moneyDTO = InputView.inputMoney();
        Money inputMoney = MoneyConverter.convert(moneyDTO);
        return vendingMachine.purchase(inputMoney);
    }
}
