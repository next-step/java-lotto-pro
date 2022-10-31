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

        LottoMoney lottoMoney = InputView.getLottoPurchasePrice();
        int customLottoTicketCount = InputView.getCustomLottoCount(lottoMoney);

        List<LottoGenerator> lottoGeneratorList = getCustomLottoNumbers(customLottoTicketCount);
        buyLotto(lottoMoney, customLottoTicketCount, lottoGeneratorList);

        ResultView.winningResult(lottoGame.winningResult());
        ResultView.StatisticsPercent(lottoGame.statisticsPercent(lottoMoney.getMoney()));
    }

    private static List<LottoGenerator> getCustomLottoNumbers(int customLottoTicketCount) {
        List<LottoGenerator> lottoGeneratorList = new ArrayList<>();

        if (customLottoTicketCount == 0) {
            return lottoGeneratorList;
        }

        InputView.customLottoNumberScript();
        for (int i = 0; i < customLottoTicketCount; i++) {
            lottoGeneratorList.add(InputView.getCustomLottoNumbers(i, customLottoTicketCount));
        }

        return lottoGeneratorList;
    }

    private void buyLotto(LottoMoney lottoMoney, int customTicketCount, List<LottoGenerator> lottoGeneratorList) {
        LottoTickets lottoTickets = lottoGame.buy(lottoMoney, lottoGeneratorList);
        ResultView.lottoPurchase(customTicketCount, lottoTickets.autoTicketCount(customTicketCount), lottoTickets.toString());
        WinningLottoNumbers winningNumbers = InputView.getWinningNumbers();
        lottoGame.makeLottoResult(winningNumbers, lottoTickets);
    }

}
