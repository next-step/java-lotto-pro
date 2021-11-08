package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoMoney;
import lotto.domain.LottoReports;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public void start() {
        LottoMoney lottoMoney = InputView.inputLottoAmount();
        List<Lotto> lottos = buyLottoTicket(lottoMoney.getCountOfPossibleLotto());
        OutputView.printLottoTickets(lottos);
        WinningLotto winningLotto = InputView.createWinningLotto();
        LottoReports lottoReports = new LottoReports(createRanks(lottos, winningLotto),
            lottoMoney);
        OutputView.printLottoReports(lottoReports);
    }

    private List<Lotto> buyLottoTicket(int countOfPossibleLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < countOfPossibleLotto; i++) {
            lottos.add(LottoFactory.createLotto());
        }
        return lottos;
    }

    private List<Rank> createRanks(List<Lotto> lottos, WinningLotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(winningLotto.createWinningRank(lotto));
        }
        return ranks;
    }
}
