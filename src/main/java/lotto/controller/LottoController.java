package lotto.controller;

import lotto.domain.*;
import lotto.exception.NotEnoughMoneyException;
import lotto.service.LottoService;
import lotto.utility.ParseUtility;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.Optional;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, ResultView resultView) {
        this.lottoService = new LottoService();
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        // 로또 구입
        Money inputMoney = getInputMoney();
        LottoTickets lottoTickets = getLottoTickets(inputMoney);

        // 당첨번호 입력
        WinningLottoNumbers winningLottoNumbers = ParseUtility.StringToWinningNumbers(inputView.inputWinningNumber(), inputView.inputBonusNumber());

        // 결과 출력
        GameResult gameResult = lottoService.getGameResult(lottoTickets, winningLottoNumbers);
        resultView.printGameResult(gameResult);
        resultView.printEarningRatio(inputMoney.toDTO(), new Money(gameResult.getPrize()).toDTO());
    }

    private Money getInputMoney() {
        try {
            return new Money(inputView.inputMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputMoney();
        }
    }

    private LottoTickets getLottoTickets(Money inputMoney) {
        // 수동 구입
        TicketAmount countsOfManualTickets = getManualTicketAmount();
        try {
            lottoService.checkEnoughMoney(inputMoney, countsOfManualTickets);
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
            return getLottoTickets(inputMoney);
        }
        LottoTickets manualLottoTickets = getManualLottoTickets(countsOfManualTickets);

        // 자동 구입
        TicketAmount countsOfAutoTickets = getCountsOfAutoTickets(inputMoney, countsOfManualTickets);
        LottoTickets autoLottoTickets = lottoService.buyAutoLottoTickets(countsOfAutoTickets);
        LottoTickets lottoTickets = autoLottoTickets.addAll(manualLottoTickets);
        resultView.printCountOfLottoTickets(countsOfManualTickets.getTicketAmount(), countsOfAutoTickets);
        resultView.printBuyResult(lottoTickets.toDTO());
        return lottoTickets;
    }

    private TicketAmount getCountsOfAutoTickets(Money inputMoney, TicketAmount countsOfManualTickets) {
        return lottoService.getCountsOfAutoTickets(inputMoney, countsOfManualTickets);
    }

    private TicketAmount getManualTicketAmount() {
        try {
            return new TicketAmount(inputView.inputCountsOfManualTickets());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getManualTicketAmount();
        }
    }

    private LottoTickets getManualLottoTickets(TicketAmount countsOfManualTickets) {
        LottoTickets manualLottoTickets = new LottoTickets(new ArrayList<>());
        for (int i = 0; i < countsOfManualTickets.getTicketAmount(); i++) {
            getManualLottoTicket(manualLottoTickets);
        }
        return manualLottoTickets;
    }

    private void getManualLottoTicket(LottoTickets manualLottoTickets) {
        try {
            manualLottoTickets.add(ParseUtility.StringToLottoTicket(inputView.inputLottoNumbers()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getManualLottoTicket(manualLottoTickets);
        }
    }
}
