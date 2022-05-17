package lotto.controller;

import static lotto.domain.Money.LOTTO_TICKET_PRICE;

import java.util.List;
import lotto.controller.converter.LottoNumbersConverter;
import lotto.controller.converter.LottoResultDTOConverter;
import lotto.controller.converter.MoneyConverter;
import lotto.controller.converter.WinningLottoConverter;
import lotto.controller.dto.LottoResultDTO;
import lotto.controller.dto.LottoTicketsDTO;
import lotto.controller.dto.MoneyDTO;
import lotto.controller.dto.WinningLottoDTO;
import lotto.domain.InputLottoInformation;
import lotto.domain.LottoNumbers;
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
        InputLottoInformation inputLottoInformation = getLottoInformation();

        PurchasedLottoTickets lottoTickets = buyLottoTickets(inputLottoInformation);

        reportingLottoTicketsInformation(lottoTickets, inputLottoInformation);

        LottoWinningResults winningResults = getResultWithWinningLotto(lottoTickets);

        reportingLottoResult(inputLottoInformation.totalLottoCount(), winningResults);

    }

    private void reportingLottoTicketsInformation(PurchasedLottoTickets lottoTickets,
                                                  InputLottoInformation lottoInformation) {
        OutputView.printPurchasedTicketsCount(lottoInformation);
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

    private PurchasedLottoTickets buyLottoTickets(InputLottoInformation inputLottoInformation) {
        return vendingMachine.purchase(inputLottoInformation);
    }

    private InputLottoInformation getLottoInformation() {
        MoneyDTO moneyDTO = InputView.inputMoney();
        Money inputMoney = MoneyConverter.convert(moneyDTO);
        int inputManualLottoQuantity = InputView.inputManualLottoQuantity();
        List<LottoNumbers> manualLottoNumbersList = getManualLottoTicket(inputManualLottoQuantity);
        return InputLottoInformation.of(inputMoney, manualLottoNumbersList);
    }

    private List<LottoNumbers> getManualLottoTicket(int inputManualLottoQuantity) {
        LottoTicketsDTO lottoTicketsDTO = InputView.inputManualLottoTickets(inputManualLottoQuantity);
        return LottoNumbersConverter.convert(lottoTicketsDTO);
    }
}
