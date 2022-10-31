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

//        int customLottoCount = Integer.parseInt(InputView.getCustomLottoCount());
//        List<LottoGenerator> lottoGeneratorList = new ArrayList<>();
//        for (int i = 0; i < customLottoCount; i++) {
//            lottoGeneratorList.add(InputView.getCustomLottoNumbers(i, customLottoCount));
//        }

        // TODO: 구매 금액 입력 후 수동로또 구매 시 구매 금액을 초과한 경우
        // TODO: 수동 로또 번호 추가 로직
        LottoTickets lottoTickets = lottoGame.buy(lottoMoney.getMoney());

        ResultView.lottoPurchase(lottoTickets.ticketCount(), lottoTickets.toString());

        String winningNumber = InputView.getLastWeekWinningNumber();
        LottoNumber bonusNumber = new LottoNumber(InputView.getBonusNumber());
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumber, bonusNumber);

        lottoGame.makeLottoResult(winningLottoNumbers, lottoTickets);

        ResultView.winningResult(lottoGame.winningResult());
        ResultView.StatisticsPercent(lottoGame.statisticsPercent(lottoMoney.getMoney()));
    }

}
