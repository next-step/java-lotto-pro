package lotto.controller;

import lotto.domain.*;
import lotto.exception.*;
import lotto.utility.ParseUtility;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        // 로또 구입
        Money inputMoney = getInputMoney();
        LottoTickets lottoTickets = getLottoTickets(inputMoney);

        // 당첨번호 입력
        WinningLottoNumbers winningLottoNumbers = getWinningLottoNumbers();

        // 결과 출력
        GameResult gameResult = lottoTickets.getGameResult(winningLottoNumbers);
        resultView.printGameResult(gameResult);
        resultView.printEarningRatio(inputMoney.toDTO(), new Money(gameResult.getPrize()).toDTO());
    }

    private WinningLottoNumbers getWinningLottoNumbers() {
        try {
            return ParseUtility.StringToWinningNumbers(inputView.inputWinningNumber(), inputView.inputBonusNumber());
        } catch (IllegalLottoNumberException | IllegalLottoNumberSizeException | NotANumberException | NumberDuplicationException e) {
            System.out.println(e.getMessage());
            return getWinningLottoNumbers();
        }
    }

    private Money getInputMoney() {
        try {
            return Money.from(inputView.inputMoney());
        } catch (NegativeMoneyException | NotANumberException e) {
            System.out.println(e.getMessage());
            return getInputMoney();
        }
    }

    private LottoTickets getLottoTickets(Money inputMoney) {
        // 수동 구입
        TicketAmount countsOfManualTickets = getManualTicketAmount(inputMoney);
        LottoTickets manualLottoTickets = getManualLottoTickets(countsOfManualTickets);

        // 자동 구입
        TicketAmount countsOfAutoTickets = getCountsOfAutoTickets(inputMoney, countsOfManualTickets);
        LottoTickets autoLottoTickets = LottoTickets.generateRandomLottoTickets(countsOfAutoTickets);
        LottoTickets lottoTickets = autoLottoTickets.addAll(manualLottoTickets);
        resultView.printCountOfLottoTickets(countsOfManualTickets.getTicketAmount(), countsOfAutoTickets);
        resultView.printBuyResult(lottoTickets.toDTO());
        return lottoTickets;
    }

    private TicketAmount getCountsOfAutoTickets(Money inputMoney, TicketAmount countsOfManualTickets) {
        int countsOfAutoTickets = inputMoney.getLottoAmount(LottoTicket.LOTTO_PRICE) - countsOfManualTickets.getTicketAmount();
        if (countsOfAutoTickets < 0) {
            throw new NotEnoughMoneyException();
        }
        return new TicketAmount(countsOfAutoTickets);
    }

    private TicketAmount getManualTicketAmount(Money inputMoney) {
        try {
            TicketAmount ticketAmount = TicketAmount.from(inputView.inputCountsOfManualTickets());
            checkEnoughMoney(inputMoney, ticketAmount);
            return ticketAmount;
        } catch (NotANumberException | IllegalTicketAmountException | NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
            return getManualTicketAmount(inputMoney);
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
        } catch (IllegalLottoNumberException | IllegalLottoNumberSizeException | NotANumberException | NumberDuplicationException e) {
            System.out.println(e.getMessage());
            getManualLottoTicket(manualLottoTickets);
        }
    }

    public void checkEnoughMoney(Money inputMoney, TicketAmount countsOfManualTickets) {
        int countsOfAutoTickets = inputMoney.getLottoAmount(LottoTicket.LOTTO_PRICE) - countsOfManualTickets.getTicketAmount();
        if (countsOfAutoTickets < 0) {
            throw new NotEnoughMoneyException();
        }
    }
}
