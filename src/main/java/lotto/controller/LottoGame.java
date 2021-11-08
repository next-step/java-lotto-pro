package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoMoney;
import lotto.domain.LottoReports;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public void start() {
        LottoMoney lottoMoney = InputView.inputLottoAmount();
        LottoTicket lottoTicket = buyLottoTicket(lottoMoney.getCountOfPossibleLotto());
        OutputView.printLottoTickets(lottoTicket);
        WinningLotto winningLotto = InputView.createWinningLotto();
        LottoReports lottoReports = new LottoReports(lottoTicket.createWinningRanks(winningLotto), lottoMoney);
        OutputView.printLottoReports(lottoReports);
    }

    private LottoTicket buyLottoTicket(int countOfPossibleLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < countOfPossibleLotto; i++) {
            lottos.add(LottoFactory.createLotto());
        }
        return new LottoTicket(lottos);
    }
}
