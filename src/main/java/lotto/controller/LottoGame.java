package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoMoney;
import lotto.domain.LottoNumber;
import lotto.domain.LottoReports;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public void start() {
        LottoMoney lottoMoney = InputView.inputLottoAmount();
        List<Lotto> lottos = buyLottoTicket(lottoMoney.getCountOfPossibleLotto());
        OutputView.printLottoTickets(lottos);
        Lotto winningLotto = InputView.inputWinningNumbersOfLastWeek();
        LottoNumber bonusNumber = InputView.inputBonusNumber(winningLotto);
        LottoReports lottoReports = new LottoReports(createRanks(lottos, winningLotto, bonusNumber),
            lottoMoney);
        OutputView.printLottoReports(lottoReports);
    }

    private List<Lotto> buyLottoTicket(int countOfPossibleLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < countOfPossibleLotto; i++) {
            lottos.add(LottoFactory.createLottoTicket());
        }
        return lottos;
    }

    private List<Rank> createRanks(List<Lotto> lottos, Lotto winningLotto,
        LottoNumber bonusNumber) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(lotto.createWinningRank(winningLotto, bonusNumber));
        }
        return ranks;
    }
}
