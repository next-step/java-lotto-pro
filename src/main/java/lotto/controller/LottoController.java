package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoService;
import lotto.utility.ParseUtility;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;

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
        Money inputMoney = new Money(inputView.inputMoney());
        LottoTickets lottoTickets = getLottoTickets(inputMoney);

        // 당첨번호 입력
        WinningLottoNumbers winningLottoNumbers = ParseUtility.StringToWinningNumbers(inputView.inputWinningNumber(), inputView.inputBonusNumber());

        // 결과 출력
        GameResult gameResult = lottoService.getGameResult(lottoTickets, winningLottoNumbers);
        resultView.printGameResult(gameResult);
        resultView.printEarningRatio(inputMoney.toDTO(), new Money(gameResult.getPrize()).toDTO());
    }

    private LottoTickets getLottoTickets(Money inputMoney) {
        // 수동 구입
        TicketAmount countsOfManualTickets = new TicketAmount(inputView.inputCountsOfManualTickets());
        LottoTickets manualLottoTickets = getManualLottoTickets(countsOfManualTickets);

        // 자동 구입
        TicketAmount countsOfAutoTickets = lottoService.getCountsOfAutoTickets(inputMoney, countsOfManualTickets);
        LottoTickets autoLottoTickets = lottoService.buyAutoLottoTickets(countsOfAutoTickets);
        LottoTickets lottoTickets = autoLottoTickets.addAll(manualLottoTickets);
        resultView.printCountOfLottoTickets(countsOfManualTickets.getTicketAmount(), countsOfAutoTickets);
        resultView.printBuyResult(lottoTickets.toDTO());
        return lottoTickets;
    }

    private LottoTickets getManualLottoTickets(TicketAmount countsOfManualTickets) {
        LottoTickets manualLottoTickets = new LottoTickets(new ArrayList<>());
        for (int i = 0; i < countsOfManualTickets.getTicketAmount(); i++) {
            manualLottoTickets.add(ParseUtility.StringToLottoTicket(inputView.inputLottoNumbers()));
        }
        return manualLottoTickets;
    }
}
