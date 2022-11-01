package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottoManualGeneratorRequestDto;
import lotto.dto.LottoMoneyRequestDto;
import lotto.dto.WinningLottoNumberRequestDto;
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
        LottoMoneyRequestDto lottoPurchasePrice = InputView.getLottoPurchasePrice();
        LottoMoney lottoMoney = lottoPurchasePrice.getLottoMoney();
        int manualLottoTicketCount = InputView.getManualLottoCount(lottoMoney);

        List<LottoGenerator> lottoGeneratorList = getManualLottoNumbers(manualLottoTicketCount);
        buyLotto(lottoMoney, manualLottoTicketCount, lottoGeneratorList);

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
            LottoManualGeneratorRequestDto manualLottoNumbers = InputView.getManualLottoNumbers(i, manualLottoTicketCount);
            lottoGeneratorList.add(manualLottoNumbers.getLottoGenerator());
        }

        return lottoGeneratorList;
    }

    private void buyLotto(LottoMoney lottoMoney, int manualTicketCount, List<LottoGenerator> lottoGeneratorList) {
        LottoTickets lottoTickets = lottoGame.buy(lottoMoney, lottoGeneratorList);
        ResultView.lottoPurchase(manualTicketCount, lottoTickets.autoTicketCount(manualTicketCount), lottoTickets.toString());
        WinningLottoNumbers winningNumbers = InputView.getWinningNumbers().getWinningLottoNumbers();
        lottoGame.makeLottoResult(winningNumbers, lottoTickets);
    }

}
