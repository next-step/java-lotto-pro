package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final LottoGame lottoGame;

    public LottoController(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }

    public void startLotto() {
        LottoMoney lottoMoney = new LottoMoney(InputView.getLottoPurchasePrice());
        int manualLottoTicketCount = InputView.getManualLottoCount(lottoMoney);

        List<LottoGenerator> lottoGeneratorList = getManualLottoNumbers(manualLottoTicketCount);
        LottoTickets lottoTickets = buyLotto(lottoMoney, manualLottoTicketCount, lottoGeneratorList);

        String[] inputWinningLottoTicket = InputView.getWinningNumbers();
        WinningLottoNumbers winningNumbers = new WinningLottoNumbers(inputWinningLottoTicket[0], Integer.parseInt(inputWinningLottoTicket[1]));
        lottoGame.makeLottoResult(winningNumbers, lottoTickets);

        ResultView.winningResult(lottoGame.winningResult());
        ResultView.StatisticsPercent(lottoGame.statisticsPercent(lottoMoney.getMoney()));
    }

    private static List<LottoGenerator> getManualLottoNumbers(int manualLottoTicketCount) {
        List<LottoGenerator> lottoGeneratorList = new ArrayList<>();

        if (manualLottoTicketCount == 0) {
            return lottoGeneratorList;
        }

        InputView.manualLottoNumberScript();
        for (int i = 0; i < manualLottoTicketCount; i++) {
            String lottoNumbers = InputView.getManualLottoNumbers();
            LottoGenerator manualLottoNumbers = new ManualLottoGenerator(lottoNumbers);
            lottoGeneratorList.add(manualLottoNumbers);
        }

        return lottoGeneratorList;
    }

    private LottoTickets buyLotto(LottoMoney lottoMoney, int manualTicketCount, List<LottoGenerator> lottoGeneratorList) {
        LottoTickets lottoTickets = lottoGame.buy(lottoMoney, lottoGeneratorList);
        ResultView.lottoPurchase(manualTicketCount, lottoTickets.autoTicketCount(manualTicketCount), lottoTickets.toString());
        return lottoTickets;
    }

}
